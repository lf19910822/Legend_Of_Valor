package Items;

//extends Spell class, has its own spellType
public class lightSpell extends Spell{
    lightSpell(String type, String name, int price, int level, int damage, int manaCost) {
        super(name, price, level, damage, manaCost, "light");
    }
}
