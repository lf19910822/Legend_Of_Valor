package Characters;
import Colors.ColorsCodes;

public class Paladin extends Human{         // the class of the Paladin

    public Paladin(String name, int HP, int Strength, int Agility, int level, int EXP, int MP, int dexterity, int gold) {
        super(name, level * 10, Strength, Agility, level, EXP, MP, dexterity, gold, ColorsCodes.YELLOW);
        super.Type = "Paladin";
    }

    public  Paladin( Paladin other){
        super(other);
        super.Type = "Paladin";
    }

    @Override
    public void levelUp(){
        this.setLevel(this.getLevel()+1);
        this.setStrength((int)(this.getStrength() * 1.3));
        this.setAgility((int)(this.getAgility() * 1.1));
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