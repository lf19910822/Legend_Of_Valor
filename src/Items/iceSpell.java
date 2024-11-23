package Items;

public class iceSpell extends Spell{    // class of ice spell
    iceSpell(String type, String name, int price, int level, int damage, int manaCost) {
        super( name, price, level, damage, manaCost, "ice");
    }
}
