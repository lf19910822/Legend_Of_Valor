package Items;


//extends Spell class, has its own spellType
public class iceSpell extends Spell{

    iceSpell(String type, String name, int price, int level, int damage, int manaCost) {
        super( name, price, level, damage, manaCost, "ice");
    }
}
