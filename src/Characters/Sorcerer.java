package Characters;
import Colors.ColorsCodes;

public class Sorcerer extends Human{     // the class of the Sorcerer
    public Sorcerer(String name, int HP, int Strength, int Agility, int level, int EXP, int MP, int dexterity, int gold) {
        super(name, level * 10, Strength, Agility, level, EXP, MP, dexterity, gold, ColorsCodes.BLUE);
        this.Type = "Sorcerer";
    }

    public Sorcerer(Sorcerer other){
        super(other);
        this.Type = "Sorcerer";
    }

    @Override
    public void levelUp(){
        this.setLevel(this.getLevel()+1);
        this.setStrength((int)(this.getStrength() * 1.1));
        this.setAgility((int)(this.getAgility() * 1.3));
        this.setDexterity((int)(this.getDexterity() * 1.3));
        this.setMP((int)(this.getMP() * 1.1));
        this.setHP((int)(this.getLevel() * 100));

        printLevelUp();
        if( this.getExpNeeded() <= this.getEXP())
            levelUp();
//        printLevelUp();
//        resetExpNeeded();
    }
}


