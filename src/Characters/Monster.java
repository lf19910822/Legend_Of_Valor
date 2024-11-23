package Characters;
import Colors.ColorsCodes;
import Items.Spell;
import workLogics.Formulas;

//The class of Monster. The Monsters’ HP depends on their levels.
public class Monster extends Character {
    private int defense;
    protected String Type;

    Monster(String name, int HP, int level, int baseDamage, int defense, int dodge, String Type) {
        super(name, level * 100, baseDamage, dodge, level, ColorsCodes.BG_BLACK);
        this.defense = defense;
        this.Type = Type;
        this.isAlive = true;
    }

    public Monster(Monster other){
        super(other);
        this.defense = other.defense;
        this.Type = other.Type;
        this.isAlive = other.isAlive;
    }

    @Override
    public String toString() {
        return String.format(
            "+----------------+----------------+\n" +
            "| Attribute      | Value          |\n" +
            "+----------------+----------------+\n" +
                    "| Type           | %-14s |\n" +
            "| NAME           | %-14s |\n" +
            "| HP             | %-14d |\n" +
            "| Level          | %-14d |\n" +
            "| Base Damage    | %-14d |\n" +
            "| Defense        | %-14d |\n" +
            "| Dodge          | %-14d |\n" +
            "+----------------+----------------+\n",
                this.getType(),
            super.getName(),
            super.getHP(),
            super.getLevel(),
            super.getStrength(),
            this.defense,
            super.getAgility()
        );
    }

    public void printAttackInformation(int index){
        System.out.printf("| %-27s | %-14s | %-14d | %-14d | %-14d |\t%d%n",
                super.getName(), this.getType(), super.getHP(), this.getDefense(), super.getAgility(), index);
    }

    public String getType() {
        return this.Type;
    }

    public void initByLevel(int level){
        if( level < this.getLevel()){
            super.setHP((int)(super.getHP() * Math.pow(0.9, this.getLevel() - level)));
        } else if( level > this.getLevel()){
            super.setHP((int)(super.getHP() * Math.pow(1.1, level - this.getLevel())));
        }
    }

    public void beAttacked( int damage ){
        super.setHP( Math.max(super.getHP() - damage, 0));
        if( super.getHP() == 0){
            this.isAlive = false;
        }
    }

    public void beAttacked(int damage, Spell spell ){
        super.setHP( Math.max(super.getHP() - damage, 0));
        if( super.getHP() == 0){
            this.isAlive = false;
        }
        Formulas.MonsterSkillLose(this, spell, 0.2);
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }


}
