package Items;

public class fireSpell extends Spell{
    fireSpell(String type, String name, int price, int level, int damage, int manaCost) {
        super(name, price, level, damage, manaCost, "fire");
    }
}
