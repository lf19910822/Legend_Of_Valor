import Characters.Human;
import Characters.Monster;
import Colors.ColorsCodes;
import places.*;
import tool.toolClass;

import java.util.ArrayList;
import java.util.List;

public class Board {                        // A class that represent a board
    protected int boardRow;
    protected int boardCol;
    protected Cell[][] cells;
    protected List<herosGroup> heroesGroups;
    protected List<aMonster> monsterGroups;

    Board(int boardCol, int boardRow) {
        this.boardCol = boardCol;
        this.boardRow = boardRow;
        this.cells = new Cell[boardRow][boardCol];
        this.heroesGroups = new ArrayList<>();
        this.monsterGroups = new ArrayList<>();
        for(int i = 0; i < boardRow; i++){
            for(int j = 0; j < boardCol; j++){
                this.cells[i][j] = new Cell(i, j);
            }
        }
        initBoardAtRandom();
        fillGroups();
    }

    void fillGroups(){
        herosGroup h1 = new herosGroup("H1", 7, 1, ColorsCodes.CYAN);
        herosGroup h2 = new herosGroup("H2", 7, 4, ColorsCodes.CYAN);
        herosGroup h3 = new herosGroup("H3", 7, 7, ColorsCodes.CYAN);

        this.heroesGroups.add(h1);
        this.heroesGroups.add(h2);
        this.heroesGroups.add(h3);

        this.cells[7][1].pushPiece(h1);
        this.cells[7][4].pushPiece(h2);
        this.cells[7][7].pushPiece(h3);

        aMonster m1 = new aMonster("M1", 0, 1, ColorsCodes.YELLOW);
        aMonster m2 = new aMonster("M2", 0, 4, ColorsCodes.YELLOW);
        aMonster m3 = new aMonster("M3", 0, 7, ColorsCodes.YELLOW);

        this.monsterGroups.add(m1);
        this.monsterGroups.add(m2);
        this.monsterGroups.add(m3);

        this.cells[0][1].pushPiece(m1);
        this.cells[0][4].pushPiece(m2);
        this.cells[0][7].pushPiece(m3);
    }

//    public void resetBoard(){
//        for(int i = 0; i < boardRow; i++){
//            for(int j = 0; j < boardCol; j++){
//                while( this.cells[i][j].getStack().size() > 1){
//                    this.cells[i][j].removeTopPiece();
//                }
//                Piece piece = getARandomPlace(i, j);
//                if( piece != null){
//                    cells[i][j].pushPiece(piece);
//                }
//            }
//        }
//        int groupRow = toolClass.getRandomNumber(0, this.boardRow - 1);
//        int groupCol = toolClass.getRandomNumber(0, this.boardCol - 1);
//        this.herosgroup.setRow(groupRow);
//        this.herosgroup.setCol(groupCol);
//        this.cells[groupRow][groupCol].pushPiece(this.herosgroup);
//    }

    void initBoardAtRandom(){
        int i, j;
        for( j = 0 ; j < this.boardCol; j++){
            this.cells[0][j] = new Cell(0, j, "N", ColorsCodes.BRIGHT_BLUE);
        }
        for( i = 1 ; i < boardRow - 1; i++){
            for( j = 0 ; j < this.boardCol ; j++ ){
                Cell currentCell = getRandomCell(i, j);
                this.cells[i][j] = currentCell;
            }
        }
        for( j = 0 ; j < this.boardCol; j++){
            this.cells[this.boardRow-1][j] = new Cell(0, j, "N", ColorsCodes.BRIGHT_BLUE);
        }

        setWall(2); setWall(5);
    }

    void setWall(int col ){
        int i;
        for( i = 0 ; i < this.boardRow; i++){
            Cell currentCell = new Cell(i, col, "I", ColorsCodes.RESET);
            Piece wall1 = new Piece("XX", i, col, ColorsCodes.BLACK, "wall");
            currentCell.pushPiece(wall1); currentCell.pushPiece(wall1);
            this.cells[i][col] = currentCell;
        }
    }


//    void createRandomGroup(){
//        int groupRow = toolClass.getRandomNumber(0, this.boardRow - 1);
//        int groupCol = toolClass.getRandomNumber(0, this.boardCol - 1);
//        herosGroup hg = new herosGroup(groupRow, groupCol);
//        this.cells[groupRow][groupCol].pushPiece(hg);
//        this.herosgroup = hg;
//    }

    public Cell getRandomCell(int row, int col){
        Cell cell = new Cell(row, col, "P", ColorsCodes.WHITE);
        int choice = toolClass.getRandomNumber(1, 100);
        if( choice <= 10 ){
            return new Cell(row, col, "O", ColorsCodes.BLACK);
        } else if( choice <= 25 ){
            return new Cell(row, col, "B", ColorsCodes.GREEN);
        } else if( choice <= 40 ){
            return new Cell(row, col, "C", ColorsCodes.BRIGHT_PURPLE);
        } else if( choice <= 55 ){
            return new Cell(row, col, "K", ColorsCodes.RED);
        }
        return cell;
    }

//    public Piece getARandomPlace(int row, int col){
//        Piece piece = null;
//        int choice = toolClass.getRandomNumber(1, 100);
//        if( choice <= 20 ){
//            piece = new wall(row, col);
//        } else if( choice <= 30 ){
//            piece = new market(row, col);
//        } else if( choice <= 50 ){
//            piece = new Monster(row, col);
//        }
//        return piece;
//    }

    public void printBoard(){
        int i;
        for( i = 0; i < boardRow; i++){
            printBoardOneRow(i);
        }
    }

    private void printBoardOneRow( int row ){
        int j;
        for( j = 0 ; j < boardCol; j++){
            String cellType = cells[row][j].getCellType();
            System.out.print("  " + cellType + " - " + cellType + " - " + cellType);
        }
        System.out.println();
        for( j = 0 ; j < boardCol; j++){
            Piece top = cells[row][j].removeTopPiece();
            Piece below = cells[row][j].peekTopPiece();
            cells[row][j].pushPiece(top);
            System.out.print("  |" + top + "   " + below + "|");
        }
        System.out.println();
        for( j = 0 ; j < boardCol; j++){
            String cellType = cells[row][j].getCellType();
            System.out.print("  " + cellType + " - " + cellType + " - " + cellType);
        }
        System.out.println();System.out.println();

    }


    public boolean checkIfAMoveIsOutOfBoard(int row, int col){
        if(row < 0 || row >= boardRow || col < 0 || col >= boardCol){
            System.out.println("Out of Map!");
            toolClass.pauseFlow();
            return true;
        }
        return false;
    }


//    public  boolean checkIfaCellIsEmpty(int row, int col){
//        return this.cells[row][col].isEmpty();
//    }

    public Cell[][] getCells() {
        return cells;
    }

    public List<herosGroup> getHerosGroup() {
        return this.heroesGroups;
    }
    public List<aMonster> getMonsterGroup() {
        return this.monsterGroups;
    }
}
