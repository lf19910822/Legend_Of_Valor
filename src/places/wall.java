package places;
import Colors.ColorsCodes;

public class wall extends Piece{        // The class of wall piece
    public wall( String sign, int row, int col, String color ){
        super(sign, row, col, color, "wall");
    }

    public wall( int row, int col ){
        super("#", row, col, ColorsCodes.BLACK, "wall");
    }
}
