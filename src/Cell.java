import places.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Cell {                 // A cell class that represent every cell on the board
    private int row;                // Every board holds a Cell[][] to place pieces
    private int col;

    private Deque<Piece> pieceStack;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.pieceStack = new ArrayDeque<>();
        this.pieceStack.offerFirst(new common(row, col, 0.15));
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    public boolean isEmpty(){
        return this.pieceStack.isEmpty();
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
    public void removeTopPiece(){
        this.pieceStack.pollFirst();
    }
}
