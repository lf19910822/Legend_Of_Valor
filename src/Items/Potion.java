package Items;
import tool.formats;
import java.util.List;

// represents an item that enhances specific attributes of a character, storing information about the attribute increase amount and the affected attributes.
public class Potion extends Items{

    private int attIncrease;
    private List<String> attAffect; // Strength/Health/Mana/HMSA/HMSADD
    public static String header = String.format(formats.PotionFormatsHeader, "Name", "Price",
            "Level", "attribute increase", "attribute affected");

    Potion(String name, int price, int level, int attIncrease, List<String> attAffect) {
        super(name, price, level, "Potion");
        this.attIncrease = attIncrease;
        this.attAffect = attAffect;
    }

    public List<String> getAttAffect() {
        return attAffect;
    }

    public int getAttIncrease() {
        return attIncrease;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for( String attAffect : attAffect ) {
            sb.append(attAffect + "/");
        }
        String row = String.format(formats.PotionFormatsDatas,
                super.getName(), super.getPrice(), super.getLevel(), this.attIncrease, sb.toString());
        return row;
    }
}
