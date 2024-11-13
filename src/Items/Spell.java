package Items;
import tool.formats;

public class Spell extends Items {

    private String spellType;    // "fire", "ice", "light"
    private int damage;
    private int manaCost;

    public static String header = String.format(formats.SpellFormatsHeader, "Type", "name", "Price",
            "Level", "damage", "manaCost");

    Spell(String name, int price, int level, int damage, int manaCost, String spellType) {
        super(name, price, level, "Spell");
        this.spellType = spellType;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    @Override
    public String toString() {
        String row = String.format(formats.SpellFormatsDatas,
                this.spellType, super.getName(), super.getPrice(), super.getLevel(), this.damage, this.manaCost);
        return row;
    }

    public void setType(String type) {
        this.spellType = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}
