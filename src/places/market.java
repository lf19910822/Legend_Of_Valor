package places;
import Colors.ColorsCodes;
import workLogics.Market;

public class market extends Piece{

    private Market market;
    public market(String sign, int row, int col, String color ) {
        super(sign, row, col, color, "market");
        market = Market.getMarket();
    }

    public market(int row, int col) {
        super("M", row, col, ColorsCodes.YELLOW, "market");
        market = Market.getMarket();
    }

    public void renewMarket(){
        this.market = Market.getMarket();
    }

    public Market getMarket() {
        return this.market;
    }

}
