package Characters;
import Colors.ColorsCodes;

public class Warriors extends Human{
    public Warriors(String name, int HP, int Strength, int Agility, int level, int EXP, int MP, int dexterity, int gold) {
        super(name, level * 100, Strength, Agility, level, EXP, MP, dexterity, gold, ColorsCodes.RED);
        this.Type = "Warrior";
    }

    public Warriors(Warriors other){
        super(other);
        this.Type = "Warrior";
    }

    @Override
    public void levelUp(){
        this.setLevel(this.getLevel()+1);
        this.setStrength((int)(this.getStrength() * 1.3));
        this.setAgility((int)(this.getAgility() * 1.3));
        this.setDexterity((int)(this.getDexterity() * 1.1));
        this.setMP((int)(this.getMP() * 1.1));
        this.setHP((int)(this.getLevel() * 100));
        resetExpNeeded();
        printLevelUp();
        if( this.getExpNeeded() <= super.getEXP())
            levelUp();
    }
}
