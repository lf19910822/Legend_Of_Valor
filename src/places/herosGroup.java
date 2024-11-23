package places;
import Characters.Human;
import Colors.ColorsCodes;
import java.util.ArrayList;
import java.util.List;

public class herosGroup extends Piece{
    private List<Human> group;
    private int groupLength;
    private boolean isIncreasedByCellType;

    //The class of herosGroup piece, who contains a list of heroes in a game.
    public herosGroup( String sign, int row, int col, String color){
        super(sign, row, col, color, "group");
        group = new ArrayList<>();
        groupLength = 0;
        isIncreasedByCellType = false;
    }

    public herosGroup( int row, int col ){
        super("P", row, col, ColorsCodes.BLUE, "group");
        group = new ArrayList<>();
        groupLength = 0;
        isIncreasedByCellType = false;
    }

    public boolean isIncreasedByCellType() {
        return isIncreasedByCellType;
    }

    public void setIncreasedByCellType(boolean increasedByCellType) {
        isIncreasedByCellType = increasedByCellType;
    }

    public List<Human> getGroup(){
        return group;
    }



    public void addAnHero(Human h){
        group.add(new Human(h));
        groupLength++;
    }

    public void delHero(Human h){
        group.remove(h);
        groupLength--;
    }
}
