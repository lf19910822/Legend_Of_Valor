package Items;

public class lightSpell extends Spell{
    lightSpell(String type, String name, int price, int level, int damage, int manaCost) {
        super(name, price, level, damage, manaCost, "light");
    }
}
