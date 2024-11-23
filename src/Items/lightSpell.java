package Items;

public class lightSpell extends Spell{  // the class of lightSpell
    lightSpell(String type, String name, int price, int level, int damage, int manaCost) {
        super(name, price, level, damage, manaCost, "light");
    }
}
