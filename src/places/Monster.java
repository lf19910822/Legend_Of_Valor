package places;
import Colors.ColorsCodes;

public class Monster extends Piece{
    public Monster( String sign, int row, int col, String color, double rateOfFight ){
        super( sign, row, col, color, "monster");
    }

    public Monster(int row, int col){
        super( "F", row, col, ColorsCodes.RED, "monster");
    }
}
