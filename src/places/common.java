package places;
import Colors.ColorsCodes;
//The class of a base place, who has a rate to give heroes group a fight.
public class common extends Piece{
    private double rateOfFight;
    public common( String sign, int row, int col, String color, double rateOfFight ){
        super(sign, row, col, color, "common");
        this.rateOfFight = rateOfFight;
    }

    public common( int row, int col, double rateOfFight ){
        super("  ", row, col, ColorsCodes.RESET, "common");
        this.rateOfFight = rateOfFight;
    }

    public double getRateOfFight() {
        return rateOfFight;
    }

    public void setRateOfFight(double rateOfFight) {
        this.rateOfFight = rateOfFight;
    }
}
