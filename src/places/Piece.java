package places;
import Colors.ColorsCodes;

public class Piece{
    protected String sign;
    String placeType;
    int row;
    int col;
    String color;
    Piece() {
        this.color = ColorsCodes.RESET;
        this.sign = this.color + "?" + ColorsCodes.RESET;
        this.placeType = "Null";
        row = 0;
        col = 0;
    }

    Piece(String sign, int row, int col, String color, String placeType ) {
        this.color = color;
        this.sign = this.color + sign + ColorsCodes.RESET;
        this.placeType = placeType;
        this.row = row;
        this.col = col;
    }

    public void setRowAndCol(int row, int col){
        this.row = row;
        this.col = col;

    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return sign;
    }
}
