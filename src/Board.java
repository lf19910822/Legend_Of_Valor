import Colors.ColorsCodes;
import places.*;
import tool.toolClass;

import java.util.List;

public class Board {                        // A class that represent a board
    protected int boardRow;
    protected int boardCol;
    protected Cell[][] cells;
    protected herosGroup herosgroup;

    Board(int boardCol, int boardRow) {
        this.boardCol = boardCol;
        this.boardRow = boardRow;
        this.cells = new Cell[boardRow][boardCol];
        for(int i = 0; i < boardRow; i++){
            for(int j = 0; j < boardCol; j++){
                this.cells[i][j] = new Cell(i, j);
            }
        }
        initBoardAtRandom();
    }

    public void resetBoard(){
        for(int i = 0; i < boardRow; i++){
            for(int j = 0; j < boardCol; j++){
                while( this.cells[i][j].getStack().size() > 1){
                    this.cells[i][j].removeTopPiece();
                }
                Piece piece = getARandomPlace(i, j);
                if( piece != null){
                    cells[i][j].pushPiece(piece);
                }
            }
        }
        int groupRow = toolClass.getRandomNumber(0, this.boardRow - 1);
        int groupCol = toolClass.getRandomNumber(0, this.boardCol - 1);
        this.herosgroup.setRow(groupRow);
        this.herosgroup.setCol(groupCol);
        this.cells[groupRow][groupCol].pushPiece(this.herosgroup);
    }

    void initBoardAtRandom(){
        for (int i = 0; i < boardRow; i++) {
            for (int j = 0; j < boardCol; j++) {
                Piece piece = getARandomPlace(i, j);
                if( piece != null){
                    cells[i][j].pushPiece(piece);
                }
            }
        }
        createRandomGroup();
    }

    void createRandomGroup(){
        int groupRow = toolClass.getRandomNumber(0, this.boardRow - 1);
        int groupCol = toolClass.getRandomNumber(0, this.boardCol - 1);
        herosGroup hg = new herosGroup(groupRow, groupCol);
        this.cells[groupRow][groupCol].pushPiece(hg);
        this.herosgroup = hg;
    }


    void initBoardWithFile(){
        List<String[]> gameMap = toolClass.loadData("src/data/gameMap.txt");
        if( gameMap.size() != boardRow || gameMap.get(0).length != boardCol){
            System.out.println("The game map is not compatible with the board size");
            System.exit(1);
        }
        for (int i = 0; i < boardRow; i++) {
            String[] cellInfo = gameMap.get(i);
            for (int j = 0; j < boardCol; j++) {
                String sign = cellInfo[j];
                switch (sign) {
                    case "C":
                        break;
                    case "W":
                        cells[i][j].pushPiece(new wall(i, j));
                        break;
                    case "F":
                        cells[i][j].pushPiece(new Monster(i, j));
                        break;
                    case "M":
                        cells[i][j].pushPiece(new market(i, j));
                        break;
                    case "G":
                        herosGroup hg = new herosGroup(i, j);
                        cells[i][j].pushPiece(hg);
                        this.herosgroup = hg;
                        break;

                    default:
                        System.out.println("Invalid sign in the game map");
                        break;
                }
            }
        }
    }

    public Piece getARandomPlace(int row, int col){
        Piece piece = null;
        int choice = toolClass.getRandomNumber(1, 100);
        if( choice <= 20 ){
            piece = new wall(row, col);
        } else if( choice <= 30 ){
            piece = new market(row, col);
        } else if( choice <= 50 ){
            piece = new Monster(row, col);
        }

        return piece;
    }


    void printBoard() {
        String borderColor = ColorsCodes.BLACK;
        String resetColor = ColorsCodes.RESET;
        for (int i = 0; i < boardRow; i++) {
            System.out.print(borderColor);
            System.out.print("+");
            for (int j = 0; j < boardCol; j++) {
                System.out.print("-----+");
            }
            System.out.print(resetColor);
            System.out.println();
            for (int j = 0; j < boardCol; j++) {
                Piece piece = cells[i][j].getStack().peekFirst();
                if (piece == null) {
                    System.out.print(borderColor + "|     " + resetColor);
                } else {
                    System.out.print(borderColor + "|  " + piece + "  " + resetColor);
                }
            }
            System.out.println(borderColor + "|" + resetColor);
        }
        System.out.print(borderColor);
        System.out.print("+");
        for (int j = 0; j < boardCol; j++) {
            System.out.print("-----+");
        }
        System.out.print(resetColor);
        System.out.println();
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

    void setBoard(Piece piece, int[] leftUp, int[] rightBot ){ // set all the cells with one piece in a subBoard

    }

    public herosGroup getHerosGroup() {
        return herosgroup;
    }
}
