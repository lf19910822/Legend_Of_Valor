package places;


//Used in teleport  to temporarily display the spaces a hero can teleport to, each marked with a unique index as its sign.

public class heroPossiblePosition extends Piece{    // a class for the possible positions of the hero when teleporting

    public heroPossiblePosition( String sign, int row, int col, String color){
        super(sign, row, col, color, "group");
    }
}
