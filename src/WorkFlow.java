import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Characters.*;
import Colors.ColorsCodes;
import places.aMonster;
import places.herosGroup;
import places.Piece;
import places.common;
import tool.toolClass;
import workLogics.Battle;
import workLogics.Market;

public class WorkFlow {
    Scanner scanner = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    Board board;
    Cell[][] cells;
    List<herosGroup> herosgroup;
    List<aMonster> monsterGroup;
    CharacterMaps chMaps;

    protected int rounds;
    protected int herosIndex;           // herosIndex %= 3, 0 1 2 means h1, h2, h3 to move
    boolean mainQuit = false;



    WorkFlow(){
        this.board = new Board(8,8);
        this.cells = board.getCells();
        this.herosgroup = board.getHerosGroup();
        this.monsterGroup = board.getMonsterGroup();
        this.chMaps = new CharacterMaps();
        this.rounds = 1;
        this.herosIndex = 0;
    }

    public void startGame(){
        welcomeWords();

        System.out.println("Please form your heroes group first:");
        pickOneHeroFlow();
        System.out.println("Enter HELP on the map for controlling help:");

//        board.printBoard();
        Piece moveResult = controls();
    }

    public Piece controls(){
        int count = 0;
        Piece moveResult = null;
        boolean quit = false;
        while(!quit && !this.mainQuit){
            System.out.println("Round " + this.rounds);
            board.printBoard();
            herosGroup currentHero = selectOneHeroPiece();
            int oldRow = currentHero.getRow();
            int oldCol = currentHero.getCol();
            int newRow;
            int newCol;

            printHelp();

            String control = scanner.nextLine();
            control = control.toUpperCase();
            switch (control){
                case "W":
                    newRow = oldRow - 1;
                    newCol = oldCol;
                    if( board.checkIfAMoveIsOutOfBoard(newRow, newCol) ){
                        break;
                    } else{
                        moveResult = HeroMeetAPlace(currentHero, newRow, newCol);
                    }
//                    quit = true;
                    break;
                case "S":
                    newRow = oldRow + 1;
                    newCol = oldCol;
                    if( board.checkIfAMoveIsOutOfBoard(newRow, newCol) ){
                        break;
                    } else{
                        moveResult = HeroMeetAPlace(currentHero, newRow, newCol);
                    }
//                    quit = true;
                    break;
                case "A":
                    newRow = oldRow;
                    newCol = oldCol - 1;
                    if( board.checkIfAMoveIsOutOfBoard(newRow, newCol) ){
                        break;
                    } else{
                        moveResult = HeroMeetAPlace(currentHero, newRow, newCol);
                    }
//                    quit = true;
                    break;
                case "D":
                    newRow = oldRow;
                    newCol = oldCol + 1;
                    if( board.checkIfAMoveIsOutOfBoard(newRow, newCol) ){
                        break;
                    } else{
                        moveResult = HeroMeetAPlace(currentHero, newRow, newCol);
                    }

                    break;
                case "I":
                    printGroupInformation();
                    toolClass.pauseFlow();
                    break;
                case "Q":
                    this.mainQuit = true;

                case "HELP":
                    printHelp();
                    toolClass.pauseFlow();
                    break;

                case "M":
                    this.board.printBoard();
                    toolClass.pauseFlow();
                    break;

                case "R":
//                    this.board.resetBoard();
//                    this.board.printBoard();
//                    printHelp();
                    break;

                default:
                    System.out.println("Invalid control");
                    toolClass.pauseFlow();
                    break;
            }

            if( this.herosIndex == 3 ){
                this.rounds++;
                AllMonstersMove();
                this.herosIndex = 0;
            }

        }
        return moveResult;
    }

    private void AllMonstersMove(){
        for( aMonster monster : this.monsterGroup ){
            int row = monster.getRow();
            int col = monster.getCol();
            List<Cell> moveTargets = getMoveTargetOfAMonster(monster);
            if(moveTargets.isEmpty())
                continue;

            Cell moveTarget = toolClass.getRandomValueFromList(moveTargets);
            if( moveTarget.getTopPieceType().equals("group") ){
                // BATTLE!!!!!!







            } else{
                this.cells[row][col].removeTopPiece();
//                this.cells[moveTarget.getRow()][moveTarget.getCol()].pushPiece(monster);    // ???Is moveTarget in this.cell?
                moveTarget.pushPiece(monster);
                monster.setRowAndCol(moveTarget.getRow(), moveTarget.getCol());
            }
        }
    }

    private List<Cell> getMoveTargetOfAMonster(aMonster monsterPiece){
        List<Cell> moveTargets = getCellsAroundOneChara(monsterPiece, 4);
        moveTargets.removeIf(cell -> cell.getTopPieceType().equals("wall") || cell.getTopPieceType().equals("monster"));
        return moveTargets;
    }


    private List<Cell> getCellsAroundOneChara( Piece me, int numDirections ){  // check target directions,
        List<Cell> neighbors = new ArrayList<>();                                  // return all target characters.
        int row = me.getRow();
        int col = me.getCol();
        int[][] Direction = new int[0][0];
        if( numDirections == 4 ){
            Direction = toolClass.directions4;
        } else{
            Direction = toolClass.directions8;
        }

        for( int[] direction : Direction ){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if( this.board.isOutOfBoard(newRow, newCol) ){
                continue;
            }
            neighbors.add(this.cells[newRow][newCol]);
        }
        return neighbors;
    }

    private herosGroup selectOneHeroPiece(){
        System.out.println("Now it's hero h" + (this.herosIndex + 1) + "'s turn to move");
        herosGroup result = this.herosgroup.get(this.herosIndex);
        this.herosIndex++;                      // 0, 1, 2, 3. 3 means all heroes have moved.
        return result;
    }

    private boolean oneHeroReborn(herosGroup hg){   //  hg is the hero that needs to be reborn
        Human hero = hg.getGroup().get(0);
        int heroIndex = this.herosgroup.indexOf(hg);
        int col = 1 + 3 * heroIndex;
        if( hero.isAlive() ){
            System.out.println("hero " + hero.getName() + " is still alive");
            return false;
        }
        hero.setAlive(true);
        hero.setNowaHP(hero.getHP());
        Cell bornCell = cells[7][col];
        Piece top = bornCell.peekTopPiece();
        if( top.getPlaceType().equals("monster") || bornCell.getStack().size() >= 4 ){; // a hero cannot reborn at a place with a monster
            System.out.println("Cannot reborn here");                                   // or a cell already has 2 characters.
            return false;
        }
        hg.setRowAndCol(7, col);
        bornCell.pushPiece(hg);

        return true;
    }


    private void printHelp(){
        System.out.println("W: Move Up");
        System.out.println("S: Move Down");
        System.out.println("A: Move Left");
        System.out.println("D: Move Right");
        System.out.println("I: Print Introductions");
        System.out.println("M: Print Map");
        System.out.println("R: reset Map");
        System.out.println("Q: Quit");
    }

    public boolean checkMonster( int row, int col ){    // check if there is a monster in target place
        if( !this.board.isOutOfBoard( row, col ) ){
            if( this.cells[row][col].peekTopPiece().getPlaceType().equals("monster") ){
                System.out.println("You cannot move on, there is a monster besides");
                toolClass.pauseFlow();
                return true;
            }
        }
        return false;

    }

    public Piece HeroMeetAPlace(herosGroup hg, int newRow, int newCol){
        Piece place = this.cells[newRow][newCol].peekTopPiece();
        int oldRow = hg.getRow();
        int oldCol = hg.getCol();
        Cell oldCell = this.cells[oldRow][oldCol];
        Cell newCell = this.cells[newRow][newCol];

        if(place.getPlaceType().equals("wall")){
//            return workFlowInMeetingAPlace(place, hero);
        } else if( place.getPlaceType().equals("group")){
//            return workFlowInMeetingAPlace(place, hero);
        }

        if( newRow == oldRow - 1 ){     // want to move on? we need to check if there is a monster above
            if( checkMonster(newRow, newCol - 1) || checkMonster(newRow, newCol + 1) ){
                return place;
            }
            if( checkMonster(oldRow, oldCol + 1) || checkMonster(oldRow, oldCol - 1) ){
                return place;
            }

        }

        hg.setRowAndCol(newRow, newCol);
        herosGroup topHG = (herosGroup) oldCell.peekTopPiece();
        Human topHero = topHG.getGroup().get(0);
        if( !topHero.getName().equals(hg.getGroup().get(0).getName()) ){  // the moving hero is under the top hero in
            oldCell.removeTopPiece();                                     // the stack
            oldCell.removeTopPiece();
            newCell.pushPiece(hg);
            oldCell.pushPiece(topHG);
            return place;
        }
        this.cells[oldRow][oldCol].removeTopPiece();
        this.cells[newRow][newCol].pushPiece(hg);
//        return workFlowInMeetingAPlace(place, this.herosgroup);
        return place;
    }

    private void printGroupInformation(){
        for( herosGroup currentGroup : this.herosgroup ){
            Human hero = currentGroup.getGroup().get(0);
            System.out.println(hero);
            hero.printArmoryORWeapon();
            hero.printOtherItems();
            System.out.println(ColorsCodes.BG_BLACK + "+--------------------------------------------" +
                    "---------------------------------+"
                    + ColorsCodes.RESET);
        }
    }



//    public Piece workFlowInMeetingAPlace(Piece place, herosGroup hgAfterMove){
//        String placeType = place.getPlaceType();
//
//        switch (placeType){
//            case "wall":
//                System.out.println("You hit the wall, but nothing happened");
//                toolClass.pauseFlow();
//                break;
//            case "market":
//                this.board.printBoard();
//                System.out.println("You are in a market, Do you want to enter? 1 YES, 0 NO");
//                int choose = toolClass.getAnIntInput(0, 1);
//                if( choose == 1 ){
//                    Market market = Market.getMarket();
//                    for(Human buyer : hgAfterMove.getGroup()){
//                        System.out.println("Welcome to the market! The buyer now is: " + buyer.getName());
//                        market.marketWorkFlow(buyer);
//                    }
//                }
//                break;
//            case "monster":
//                System.out.println("You are in a fight");
//                Battle regularBattle = Battle.getABattle(this.herosgroup);
//                boolean regularBattleResult = regularBattle.battleWorkFlow();
//                if( !regularBattleResult ){
//                    System.out.println("You are defeated, game over");
//                    this.mainQuit = true;
//                }
//                break;
//            case "common":
//                common common = (common) place;
//                double battleRate = common.getRateOfFight();
//                if( toolClass.Dice(battleRate) ){
//                    System.out.println("You encountered a monster ambush!");
//                    Battle EncounterBattle = Battle.getABattle(this.herosgroup);
//                    boolean EncounterBattleResult = EncounterBattle.battleWorkFlow();
//                    if( !EncounterBattleResult ){
//                        System.out.println("You are defeated, game over");
//                        this.mainQuit = true;
//                    }
//                }
//                break;
//            default:
//                break;
//        }
//        return place;
//    }

    private void pickOneHeroFlow(){
        boolean quit = false;
        int count = 0;
        while(!quit){
            if( count == 3 ){
                System.out.println("The story unfolds......");
                break;
            }
            System.out.println("You have picked " + count + "/3 heroes, this hero is in line " + (count + 1));
            System.out.println("Please pick a hero from the following list:");
            System.out.println("1. Warrior");
            System.out.println("2. Sorcerer");
            System.out.println("3. Paladin");
            int choice = toolClass.getAnIntInput(1, 5);
            if( choice == -1 )
                continue;

            switch (choice){
                case 1:
                    System.out.println("You chose Warrior");
                    Warriors warrior = (Warriors) toolClass.getRandomValueFromMap(this.chMaps.getWarriorMap());
                    System.out.println(warrior);
                    this.herosgroup.get(count).addAnHero(warrior);
                    count++;
                    break;
                case 2:
                    System.out.println("You chose Sorcerer");
                    Sorcerer sorcerer = (Sorcerer) toolClass.getRandomValueFromMap(this.chMaps.getSorcererMap());
                    System.out.println(sorcerer);
                    this.herosgroup.get(count).addAnHero(sorcerer);
                    count++;
                    break;
                case 3:
                    System.out.println("You chose Paladin");
                    Paladin paladin = (Paladin) toolClass.getRandomValueFromMap(this.chMaps.getPaladinMap());
                    System.out.println(paladin);
                    this.herosgroup.get(count).addAnHero(paladin);
                    count++;
                    break;
                default:
                    if( count < 3 ){
                        System.out.println("You must pick 3 heroes");
                        continue;
                    }
                    break;
            }
        }

        toolClass.pauseFlow();
    }


    public static void welcomeWords(){
        System.out.println(" Legends: Monsters and Heroes ");
        System.out.println("Welcome, brave heroes, to a land shrouded in mystery and danger. ");
        System.out.println("You, marked as " + ColorsCodes.BLUE + "P" + ColorsCodes.RESET + " on the map, " +
                "travel as a united group of adventurers, bound by fate to face daunting challenges. ");
        System.out.println("Beware the " + ColorsCodes.RED + "F" + ColorsCodes.RESET + " symbols----these mark encounters " +
                "where fierce enemies await, ready to test your strength.");
        System.out.println("Seek the " + ColorsCodes.YELLOW + "M" + ColorsCodes.RESET + " for safe havens; " +
                "these are bustling markets where you can trade, " +
                "gather supplies, and gain much-needed respite.");
        System.out.println("As you journey, you’ll encounter the impassable " + ColorsCodes.BLACK + "#" + ColorsCodes.RESET +
                " walls, which block your path, forcing you to navigate wisely. Forge ahead with courage, for glory and honor await!");
        toolClass.pauseFlow();
    }


}
