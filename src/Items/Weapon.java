package Items;
import tool.formats;


//represents a type of item in the game, encapsulating properties such as damage, required hands, and associated costs, with functionality for formatted display.
public class Weapon extends Items{
    private int damage;
    private int requiredHands;

    public static String header = String.format(formats.WeaponFormatsHeader, "Name", "Price", "Level",
            "Damage", "RequiredHands");

    public Weapon(String name, int price, int level, int damage, int requiredHands) {
        super(name, price, level, "Weapon");
        this.damage = damage;
        this.requiredHands = requiredHands;
    }

    public int getRequiredHands() {
        return requiredHands;
    }

    public void setRequiredHands(int requiredHands) {
        this.requiredHands = requiredHands;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        String row = String.format(formats.WeaponFormatsDatas,
                super.getName(), super.getPrice(), super.getLevel(), this.damage, this.requiredHands);

        return row;
    }

}