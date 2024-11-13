package Items;
import tool.formats;

public class Armory extends Items{
    private int damageReduction;
    public static String header = String.format(formats.ArmoryFormatsHeader, "Name", "Price", "Level", "Damage Reduction");

    Armory(String name, int price, int level, int damageReduction) {
        super(name, price, level, "Armory");
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    @Override
    public String toString() {

        String row = String.format(formats.ArmoryFormatsDatas,
                super.getName(), super.getPrice(), super.getLevel(), this.damageReduction);

        return row;
    }

}
