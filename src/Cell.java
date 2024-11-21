import Colors.ColorsCodes;
import places.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Cell {                 // A cell class that represent every cell on the board
    private int row;                // Every board holds a Cell[][] to place pieces
    private int col;
    private String cellType;    // NIPCBK

    private Deque<Piece> pieceStack;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.pieceStack = new ArrayDeque<>();
        this.pieceStack.offerFirst(new common(row, col, 0));
        this.pieceStack.offerFirst(new common(row, col, 0));
        this.cellType = "P";
    }

    public Cell(int row, int col, String type, String color) {
        this.row = row;
        this.col = col;
        this.pieceStack = new ArrayDeque<>();
        this.pieceStack.offerFirst(new common(row, col, 0));
        this.pieceStack.offerFirst(new common(row, col, 0));
        this.cellType = color + type + ColorsCodes.RESET;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    public boolean isEmpty(){
        if(Objects.equals(this.peekTopPiece().getPlaceType(), "common")){
            return true;
        }
        return false;
    }

    public String getTopPieceType(){
        if( !pieceStack.isEmpty() ){
            return pieceStack.peekFirst().getPlaceType();
        }
        return "null";
    }

    public Piece peekSecondPiece(){
        if( pieceStack.size() < 2 ){
            System.out.println("Error: No enough pieces in the stack.");
            return null;
        }
        Piece top = pieceStack.pollFirst();
        Piece below = pieceStack.peekFirst();
        pieceStack.offerFirst(top);
        return below;
    }


    public void pushPiece(Piece piece){
        this.pieceStack.offerFirst(piece);
    }

    public Deque<Piece> getStack(){
        return this.pieceStack;
    }

    public Piece peekTopPiece(){
        return this.pieceStack.peekFirst();
    }
    public Piece removeTopPiece(){
        return this.pieceStack.pollFirst();
    }

    public String getCellType() {
        return cellType;
    }

    public void setCellType(String cellType) {
        this.cellType = cellType;
    }
}
