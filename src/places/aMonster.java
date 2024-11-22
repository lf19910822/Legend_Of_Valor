package places;

import Characters.Monster;
import Colors.ColorsCodes;

public class aMonster extends Piece{
    private Monster monster;                        // need to be set
    public aMonster( String sign, int row, int col, String color){
        super(sign, row, col, color, "monster");
    }

    public aMonster( String sign, int row, int col, String color, Monster monster){
        super(sign, row, col, color, "monster");
        this.monster = monster;
    }

    public aMonster( int row, int col ){
        super("M ", row, col, ColorsCodes.YELLOW, "monster");
    }

    public Monster getMonster(){
        return monster;
    }
    public void setMonster(Monster monster){
        this.monster = monster;
    }
}
