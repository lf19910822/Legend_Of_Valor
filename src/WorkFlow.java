import java.util.*;

import Characters.*;
import Colors.ColorsCodes;
import places.*;
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
    List<aMonster> monsterToRemove;
    CharacterMaps chMaps;

    protected int rounds;
    protected int herosIndex;           // herosIndex %= 3, 0 1 2 means h1, h2, h3 to move
    boolean mainQuit = false;
    protected herosGroup currentHero;
    Battle battle;

    HashSet<String> possibleLocationSet;

    WorkFlow(){
        this.board = new Board(8,8);
        this.cells = board.getCells();
        this.herosgroup = board.getHerosGroup();
        this.monsterGroup = board.getMonsterGroup();
        this.monsterToRemove = new ArrayList<>();
        this.chMaps = new CharacterMaps();
        this.rounds = 1;
        this.herosIndex = 0;

        for( aMonster monsterPiece : this.monsterGroup ){
            Monster monster = getRandomMonster();
            monsterPiece.setMonster(monster);
        }
    }

    public void startGame(){
        welcomeWords();

        System.out.println("Please form your heroes group first:");
        pickOneHeroFlow();
        System.out.println("Enter HELP on the map for controlling help:");

//        board.printBoard();
        controls();
    }

    private static String removeAnsiCodes(String input) {       // remove ANSI codes
        return input.replaceAll("\u001b\\[[;\\d]*m", "");
    }

    private String getCellType( Piece piece ){
        int row = piece.getRow();
        int col = piece.getCol();
        return removeAnsiCodes(this.cells[row][col].getCellType());
    }



    private void increaseByCellType( herosGroup hg, int rate ){
        if( hg.isIncreasedByCellType() ){               // if the hero has already been increased by cell type, do nothing
            return;
        }
        Human hero = hg.getGroup().get(0);
        String cellType = getCellType(hg);
        switch (cellType){
            case "C":
                hero.setNowaAgility(hero.getNowaAgility() + rate);
                break;
            case "B":
                hero.setNowaDexterity(hero.getNowaDexterity() + rate);
                break;
            case "K":
                hero.setNowaStrength(hero.getNowaStrength() + rate);
                break;
            default:
                break;
        }
    }

    private void printIncreasedByCellType( herosGroup hg, int rate ){
        String cellType = getCellType(hg);
        switch (cellType){
            case "C":
                System.out.println("Hero H" + (this.herosIndex) + " steps on a " + ColorsCodes.PURPLE + "Cave!" + ColorsCodes.RESET);
                System.out.println("Hero H" + (this.herosIndex) + "'s agility is increased by " + rate);
                break;
            case "B":
                System.out.println("Hero H" + (this.herosIndex) + " steps on a " + ColorsCodes.GREEN + "Bush!" + ColorsCodes.RESET);
                System.out.println("Hero H" + (this.herosIndex) + "'s dexterity is increased by " + rate);
                break;
            case "K":
                System.out.println("Hero H" + (this.herosIndex) + " steps on a " + ColorsCodes.RED + "Koulou!" + ColorsCodes.RESET);
                System.out.println("Hero H" + (this.herosIndex) + "'s strength is increased by " + rate);
                break;
            default:
                break;
        }



    }

    public void controls(){
        boolean moveResult = true;
        boolean quit = false;
        boolean reSelect = true;
        while(!quit && !this.mainQuit){
            board.printBoard();
            System.out.println("Round " + this.rounds);
            if( this.rounds % 3 == 0 ){
                generateMonsters();
                System.out.println("Monsters generated!");
                board.printBoard();
            }
            if( reSelect ){
                this.currentHero = selectOneHeroPiece();
                System.out.println("Now it's hero H" + (this.herosIndex + 1) + "'s turn to move");
                this.herosIndex++;
            } else{
                this.herosIndex--;
                this.currentHero = selectOneHeroPiece();
                System.out.println("Now it's hero H" + (this.herosIndex + 1) + "'s turn to move");
                this.herosIndex++;
                reSelect = true;
            }
            printIncreasedByCellType(this.currentHero, 200);


//            herosGroup currentHero = selectOneHeroPiece();
            int oldRow = currentHero.getRow();
            int oldCol = currentHero.getCol();
            int newRow;
            int newCol;
            Human hero = currentHero.getGroup().get(0);
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
                        int checkWin = checkWin();
                        if( checkWin == 1 ){
                            this.mainQuit = true;
                            break;
                        }
                        if( !moveResult ){
                            toolClass.pauseFlow();
                            reSelect = false;
                            continue;
                        }
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

                        if( !moveResult ){
                            toolClass.pauseFlow();
                            reSelect = false;
                            continue;
                        }
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

                        if( !moveResult ){
                            toolClass.pauseFlow();
                            reSelect = false;
                            continue;
                        }
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

                        if( !moveResult ){
                            toolClass.pauseFlow();
                            reSelect = false;
                            continue;
                        }
                    }

                    break;

                case "P":
                    System.out.println("Hero H" + (this.herosIndex) + " do nothing in this turn");
                    toolClass.pauseFlow();
                    break;

                case "I":
                    printGroupInformation();
                    reSelect = false;
                    toolClass.pauseFlow();
                    continue;
                case "Q":
                    this.mainQuit = true;
                    break;
                case "HELP":
                    printHelp();
                    toolClass.pauseFlow();
                    reSelect = false;
                    continue;
                case "ATTACK":
                    boolean battleResult = heroAttackFlow(currentHero);
                    if( !battleResult ){
                        reSelect = false;
                        continue;
                    }
                    break;
                case "RECALL":
                    boolean recallResult = recall(currentHero);
                    if( !recallResult ){
                        reSelect = false;
                        continue;
                    }
                    break;
                case "TELEPORT":
                    boolean telePortResult = telePort(currentHero);
                    if(!telePortResult){
                        reSelect = false;
                        continue;
                    }
                    break;

                case "ITEM":
                    if(!hero.useItemsFlow()){
                        reSelect = false;
                        continue;
                    }
                    break;

                case "M":
                    if( getCellType(currentHero).equals("N") ){

                        Market market = Market.getMarket();
                        market.marketWorkFlow(hero);
                    } else{
                        System.out.println("You can only enter a market when you are in " + ColorsCodes.BLUE + " Nexus"
                                + ColorsCodes.RESET);
                        toolClass.pauseFlow();
                        reSelect = false;
                        continue;
                    }
                    break;

                default:
                    System.out.println("Invalid control");
                    toolClass.pauseFlow();
                    reSelect = false;
                    continue;
            }

            if( this.mainQuit && checkWin() == 1 ){ // hero wins
                printWinWords();
                break;
            }

            if( this.herosIndex == 3 ){
                this.rounds++;
                AllMonstersMove();
                if( checkWin() == 2 ){  // monster wins
                    printWinWords();
                    this.mainQuit = true;
                }
                this.herosIndex = 0;
            }

        }
    }

    private void deleteMonsters(){  // we cannot delete monsters during a for loop.
        if( this.monsterToRemove.isEmpty() ){
            return;
        }
        this.monsterGroup.removeAll(this.monsterToRemove);
    }

    private void battleLogic( herosGroup hg, aMonster monsterPiece, int start ){   // start: 1 hero start, 0 monster start
        this.battle = new Battle(hg, monsterPiece);
        Piece result;
        if( start == 1 ){
            result = this.battle.heroStartFlow();
        } else{
            result = this.battle.monsterStartFlow();
        }
        if( result.getPlaceType().equals("group") ){
            this.battle.endSingleBattle();
            popAMonsterPiece(monsterPiece);
            this.monsterToRemove.add(monsterPiece);
//            this.monsterGroup.remove(monsterPiece);
//            this.monsterGroup.removeIf(monster -> monster.equals(monsterPiece));
        } else if( result.getPlaceType().equals("monster") ){
            this.battle.endFailedBattle();
            Cell battleCell = this.cells[hg.getRow()][hg.getCol()];
            battleCell.removeTopPiece();
            oneHeroReborn(hg);
        }
    }

    private boolean heroAttackFlow( herosGroup hg ){
        Iterator<aMonster> iterator = this.monsterGroup.iterator();
        List<aMonster> monsterPieces = getHeroAttackTargets(hg);
        if( monsterPieces.isEmpty() ){
            System.out.println("No monster to attack");
            return false;
        }

        System.out.println("Monsters to be attacked:");
        for( aMonster monsterPiece : monsterPieces ){
            Monster monster = monsterPiece.getMonster();
            System.out.println(monsterPiece.getSign() + ":");
            System.out.println(monster);
            System.out.println();
        }

        boolean quit = false;
        int choose = -1;
        while(!quit) {
            System.out.println("Please choose a monster to attack:");
            printMonstersToBeAttacked(monsterPieces);
            choose = toolClass.getAnIntInput(0, monsterPieces.size() - 1);
            if (choose != -1) {
                quit = true;
            }
        }
        aMonster target = monsterPieces.get(choose);
        this.battleLogic(hg, target, 1);
        deleteMonsters();
//        this.battle = new Battle(hg, target);
//        Piece result = this.battle.heroStartFlow();             // get the result of the battle
//        if( result.getPlaceType().equals("group") ){
//            this.battle.endSingleBattle();
//            popAMonsterPiece(target);
//        } else if( result.getPlaceType().equals("monster") ){
//            this.battle.endFailedBattle();
//            Cell battleCell = this.cells[hg.getRow()][hg.getCol()];
//            battleCell.removeTopPiece();
//            oneHeroReborn(hg);
//        }

        System.out.println("One total battle round ends");
        return true;
    }

    private void popAMonsterPiece( aMonster monsterPiece ){
        int row = monsterPiece.getRow();
        int col = monsterPiece.getCol();
        Cell cell = this.cells[row][col];
        Piece top = cell.peekTopPiece();
        Piece below = cell.peekSecondPiece();
        if( top == monsterPiece ){
            cell.removeTopPiece();
        } else if( below == monsterPiece ){
            cell.removeTopPiece();
            cell.removeTopPiece();
            cell.pushPiece(top);
        }
    }

    private void printMonstersToBeAttacked(List<aMonster> monsterPieces){
        for( aMonster monsterPiece : monsterPieces ){
            Monster monster = monsterPiece.getMonster();
            System.out.println(monster.getName() + " : " + monsterPieces.indexOf(monsterPiece) );
        }
    }

    private List<aMonster> getHeroAttackTargets( herosGroup hg ){
        int row = hg.getRow();
        int col = hg.getCol();
        List<aMonster> monsterPieces = new ArrayList<>();
        List<Cell> attackTargets = getCellsAroundOneChara(hg, 8);
        for( Cell cell : attackTargets ){
            Piece target = cell.peekTopPiece();
            if( target.getPlaceType().equals("monster")){
                monsterPieces.add((aMonster) target);
            }
        }
        Piece below = this.cells[row][col].peekSecondPiece();
        if( below.getPlaceType().equals("monster")){
            monsterPieces.add((aMonster) below);
        }
        return monsterPieces;
    }


    private void AllMonstersMove(){
        for( aMonster monster : this.monsterGroup ){
            int row = monster.getRow();
            int col = monster.getCol();
            Cell origin = this.cells[row][col];
            if( origin.getTopPieceType().equals("group") ){ // Here is a hero above the monster
                // BATTLE!!!!!!
                herosGroup target = (herosGroup) origin.peekTopPiece();
                this.battleLogic(target, monster, 0);
//                this.battle = new Battle(target, monster);
//                Piece result = this.battle.monsterStartFlow();
//                if( result.getPlaceType().equals("group") ){
//                    this.battle.endSingleBattle();
//                    popAMonsterPiece(monster);
//                } else if( result.getPlaceType().equals("monster") ){
//                    this.battle.endFailedBattle();
//                    origin.removeTopPiece();
//                    oneHeroReborn(target);
//                }
                continue;
            }
            List<Cell> moveTargets = getMoveTargetOfAMonster(monster);
            if(moveTargets.isEmpty())
                continue;

            Cell moveTarget = toolClass.getRandomValueFromList(moveTargets);
            if( moveTarget.getTopPieceType().equals("group") ){
                // BATTLE!!!!!!
                herosGroup target = (herosGroup) moveTarget.peekTopPiece();
                this.battle = new Battle(target, monster);
                Piece result = this.battle.monsterStartFlow();
                if( result.getPlaceType().equals("group") ){
                    this.battle.endSingleBattle();
                    popAMonsterPiece(monster);
//                    this.monsterGroup.remove(monster);
                } else if( result.getPlaceType().equals("monster") ){
                    this.battle.endFailedBattle();
                    moveTarget.removeTopPiece();
                    Piece nowTop = moveTarget.peekTopPiece();
                    if( nowTop.getPlaceType().equals("monster") ){  // if there is another monster in the cell,
                        return;                                     // the winner monster cannot move to the cell.
                    }
                    this.cells[row][col].removeTopPiece();
                    moveTarget.pushPiece(monster);
                    monster.setRowAndCol(moveTarget.getRow(), moveTarget.getCol());
                    if( checkWin() == 2 ){
                        this.mainQuit = true;
                        break;
                    }
                    oneHeroReborn(target);
                }
            } else{
                ///
                if( cells[row][col].getStack().isEmpty()){
                    System.out.println("Error: No enough pieces in the stack. cell " + row + " " + col);
                }
                ///
                this.cells[row][col].removeTopPiece();
//                this.cells[moveTarget.getRow()][moveTarget.getCol()].pushPiece(monster);    // ???Is moveTarget in this.cell?
                moveTarget.pushPiece(monster);
                monster.setRowAndCol(moveTarget.getRow(), moveTarget.getCol());
                if( checkWin() == 2 ){
                    this.mainQuit = true;
                    break;
                }
            }
        }
        deleteMonsters();
    }



    private List<Cell> getMoveTargetOfAMonster(aMonster monsterPiece){  // no wall, no monster, and no walk backwards
        List<Cell> moveTargets = getCellsAroundOneChara(monsterPiece, 4);
        moveTargets.removeIf(cell -> cell.getTopPieceType().equals("wall") || cell.getTopPieceType().equals("monster"));
        moveTargets.removeIf(cell -> cell.getRow() == monsterPiece.getRow() - 1);
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
//        System.out.println("Now it's hero H" + (this.herosIndex + 1) + "'s turn to move");
        herosGroup result = this.herosgroup.get(this.herosIndex);
//        this.herosIndex++;                      // 0, 1, 2, 3. 3 means all heroes have moved.
        return result;
    }

    private boolean oneHeroReborn(herosGroup hg){   //  hg is the hero that needs to be reborn
        Human hero = hg.getGroup().get(0);
        int heroIndex = this.herosgroup.indexOf(hg);
        int col = 1 + 3 * heroIndex;
        hero.setAlive(true);
        hero.setNowaHP(hero.getHP());
        Cell bornCell = cells[7][col];
        Piece top = bornCell.peekTopPiece();
        if( top.getPlaceType().equals("group") || bornCell.getStack().size() >= 4 ){; // a hero cannot reborn at a place with another hero
            System.out.println("Hero reborn failed! The place is occupied!");           // or a cell already has 2 characters.
            return false;
        }
        hg.setRowAndCol(7, col);
        bornCell.pushPiece(hg);

        return true;
    }

    private boolean recall( herosGroup hg ){                    // recall a hero to the board
        Cell currentCell = this.cells[hg.getRow()][hg.getCol()];
        int heroIndex = this.herosgroup.indexOf(hg);
        int col = 1 + 3 * heroIndex;
        Cell bornCell = this.cells[7][col];
        Piece top = bornCell.peekTopPiece();
        if( !bornCell.isEmpty() ){;                                     // a hero cannot reborn at a place with a monster
            System.out.println("recall failed, place is occupied");     // or a cell already has 2 characters.
            return false;
        }
        bornCell.pushPiece(hg);
        hg.setRowAndCol(7, col);
        currentCell.removeTopPiece();
        return true;
    }

    private boolean telePort(herosGroup hg){
        int heroIndex1=this.herosIndex%this.herosgroup.size();
        int heroIndex2=(this.herosIndex+1)%this.herosgroup.size();
        List<heroPossiblePosition> possiblePositions= getPossiblePosition(heroIndex1,heroIndex2);
        if(possiblePositions.size()<1){
            System.out.println("No valid space that hero can teleport to!");
            return false;
        }
        for(int i=0;i<possiblePositions.size();i++){
            heroPossiblePosition hpp =possiblePositions.get(i);
            int newRow = hpp.getRow();
            int newCol = hpp.getCol();
            this.cells[newRow][newCol].pushPiece(hpp);
        }
        this.board.printBoard();
        System.out.println("Please choose a index of the space that you want to teleport to.");
        int choose = toolClass.getAnIntInput(1,possiblePositions.size());
        for(int i=0;i<possiblePositions.size();i++){
            heroPossiblePosition hpp =possiblePositions.get(i);
            int newRow = hpp.getRow();
            int newCol = hpp.getCol();
            this.cells[newRow][newCol].removeTopPiece();
        }
        heroPossiblePosition hpp =possiblePositions.get(choose-1);
        int newRow = hpp.getRow();
        int newCol = hpp.getCol();
        HeroMeetAPlace(hg,newRow,newCol);
        return true;
    }

    private List<heroPossiblePosition> getPossiblePosition(int heroIndex1,int heroIndex2){
        herosGroup hero1 = this.herosgroup.get(heroIndex1);
        herosGroup hero2 = this.herosgroup.get(heroIndex2);
        List<heroPossiblePosition> result = new ArrayList<>();
        int currentHeroCol = this.currentHero.getCol();
        int index=1;
        int hero1Row = hero1.getRow();
        int hero1Col = hero1.getCol();
        int hero2Row = hero2.getRow();
        int hero2Col = hero2.getCol();
        this.possibleLocationSet = new HashSet<>();
        if(Math.abs(currentHeroCol-hero1Col)>1){
            result.addAll(checkPossibleTelePortDestinationPerHero(hero1Row,hero1Col,index));
        }
        index+=result.size();
        if(Math.abs(currentHeroCol-hero2Col)>1){
            result.addAll(checkPossibleTelePortDestinationPerHero(hero2Row,hero2Col,index));
        }
        return result;
    }

    private List<heroPossiblePosition>checkPossibleTelePortDestinationPerHero(int row, int col,int startIndex){
        List<heroPossiblePosition> result = new ArrayList<>();
        int index = startIndex;
        if(canBeTeleportDestination(row+1,col)){
            result.add(new heroPossiblePosition(index+" ",row+1,col,ColorsCodes.BRIGHT_YELLOW));
            index++;
        }
        if(canBeTeleportDestination(row,col+1)){
            result.add(new heroPossiblePosition(index+" ",row,col+1,ColorsCodes.BRIGHT_YELLOW));
            index++;
        }
        if(canBeTeleportDestination(row,col-1)){
            result.add(new heroPossiblePosition(index+" ",row,col-1,ColorsCodes.BRIGHT_YELLOW));
        }
        return result;
    }
    private boolean canBeTeleportDestination(int row, int col){
        if(row < 0 || row >= this.board.boardRow || col < 0 || col >= this.board.boardCol){
            return false;
        }
        Cell destinationCell = this.cells[row][col];
        Piece place = this.cells[row][col].peekTopPiece();
        String location = Integer.toString(row+10*col);
        if(possibleLocationSet.contains(location)){
            return false;
        }
        if(destinationCell.getCellType().equals("\033[30mO\033[0m")||destinationCell.getCellType().equals("\033[0mI\033[0m")){
            return false;
        }
        if(place.getPlaceType().equals("group")){
            return false;
        }
        possibleLocationSet.add(location);
        return true;
    }
    private void printHelp(){
        System.out.println("WASD: Move");
        System.out.println("P: Do nothing");
        System.out.println("I: Print Introductions");
        System.out.println("M: Enter a market(If you are in" + ColorsCodes.BLUE + " Nexus" + ColorsCodes.RESET + ")");
        System.out.println("Item: Pick or Drop an item");
        System.out.println("ATTACK: Attack a monster");
        System.out.println("RECALL: Recall a hero");
        System.out.println("TELEPORT: Teleport a hero");
        System.out.println("Q: Quit");
    }

    public boolean checkMonster( int row, int col ){    // check if there is a monster in target place
        if( !this.board.isOutOfBoard( row, col ) ){
            if( this.cells[row][col].peekTopPiece().getPlaceType().equals("monster") ){
                System.out.println("You cannot move on, there is a monster besides");
//                toolClass.pauseFlow();
                return true;
            }
        }
        return false;

    }

    private Monster getRandomMonster(){
        int choice = toolClass.getRandomNumber(1, 100);
        if( choice <= 33 ){
            return toolClass.getRandomValueFromMap(this.chMaps.getDragonMap());
        } else if( choice <= 66 ){
            return toolClass.getRandomValueFromMap(this.chMaps.getExoMap());
        } else{
            return toolClass.getRandomValueFromMap(this.chMaps.getSpiritsMap());
        }
    }



    public boolean HeroMeetAPlace(herosGroup hg, int newRow, int newCol){
        Piece place = this.cells[newRow][newCol].peekTopPiece();
        int oldRow = hg.getRow();
        int oldCol = hg.getCol();
        Cell oldCell = this.cells[oldRow][oldCol];
        Cell newCell = this.cells[newRow][newCol];

        if(place.getPlaceType().equals("wall")){
            System.out.println("You hit the wall, but nothing happened");
            return false;
        } else if( place.getPlaceType().equals("group")){
            System.out.println("You cannot step on another hero!");
            return false;
        }

        if(newCell.getCellType().equals("\033[30mO\033[0m")){
            boolean choose=HeroMeetObstacle();
            if(choose){
                newCell.setCellType(ColorsCodes.WHITE+"P"+ColorsCodes.RESET);
            }else{
                return false;
            }
        }
        if( newRow == oldRow - 1 ){     // want to move on? we need to check if there is a monster above
            if( checkMonster(newRow, newCol - 1) || checkMonster(newRow, newCol + 1) ){
                return false;
            }
            if( checkMonster(oldRow, oldCol + 1) || checkMonster(oldRow, oldCol - 1) ){
                return false;
            }
            if( oldCell.peekSecondPiece().equals("monster")){
                System.out.println("You cannot move on, there is a monster in the cell");
                return false;
            }
        }
        hg.setRowAndCol(newRow, newCol);
        this.cells[oldRow][oldCol].removeTopPiece();

        Human hero = hg.getGroup().get(0);
        hero.resetNowaAttributes();
        hg.setIncreasedByCellType(false);
        increaseByCellType(hg, 200);

        this.cells[newRow][newCol].pushPiece(hg);
//        return workFlowInMeetingAPlace(place, this.herosgroup);
        return true;
    }

    private boolean HeroMeetObstacle(){
        System.out.println("You can not enter a space with type Obstacle, however, you can choose to use a turn to remove it. Do you want to do so? 1 YES, 0 NO");
        int choose = toolClass.getAnIntInput(0, 1);
        return choose==1;
    }
    private void printGroupInformation(){
            herosGroup currentGroup = this.currentHero;
            Human hero = currentGroup.getGroup().get(0);
            System.out.println(hero);
            hero.printArmoryORWeapon();
            hero.printOtherItems();
            System.out.println(ColorsCodes.BG_BLACK + "+--------------------------------------------" +
                    "---------------------------------+"
                    + ColorsCodes.RESET);

    }

    public int checkWin(){              // 0 noWinner, 1 heroWin, 2 monsterWin
        int i, j;
        for( j = 0 ; j < this.board.boardCol; j++){
            if( this.cells[0][j].peekTopPiece() instanceof herosGroup){
                return 1;
            }
        }

        for( j = 0 ; j < this.board.boardCol; j++){
            if( this.cells[7][j].peekTopPiece() instanceof aMonster){
                return 2;
            }
        }

        return 0;
    }

    private void printWinWords(){
        int result = checkWin();
        if( result == 1 ){
            this.board.printBoard();
            System.out.println("****************Game over, Heroes win!****************");
        } else if( result == 2 ){
            this.board.printBoard();
            System.out.println("****************Game over, Monsters win!****************");
        }
    }

    private void generateMonsters(){
        for( int col = 1 ; col <= 7 ; col += 3 ){
            if( !this.cells[0][col].isEmpty() ){
                continue;
            }
            aMonster monsterPiece = new aMonster(0, col);
            Monster monster = getRandomMonster();
//            monsterPiece.setMonster(monster);
            monsterPiece.setMonster(new Monster(monster));
            this.monsterGroup.add(monsterPiece);
            this.cells[0][col].pushPiece(monsterPiece);
        }
    }

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
