package Characters;

import Colors.ColorsCodes;


//The parent class of Monster and human, which contains some common attributes between human and monster.
public class Character {

    private String name;
    private int HP;
    private int Strength;
    private int Agility;
    private int level;
    private int deadRound;
    private int color;
    protected boolean isAlive;

    Character(String name, int HP, int Strength, int Agility ,int level, String color){
        this.name = color + name + ColorsCodes.RESET;
        this.HP = level * 100;
        this.Strength = Strength;
        this.Agility = Agility;
        this.level = level;
        this.deadRound = 0;
    }

    Character(Character other){
        this.name = other.name;
        this.HP = other.HP;
        this.Strength = other.Strength;
        this.Agility = other.Agility;
        this.level = other.level;
        this.deadRound = 0;
    }

    public int getDeadRound() {
        return deadRound;
    }

    public void setDeadRound(int deadRound) {
        this.deadRound = deadRound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getAgility() {
        return Agility;
    }

    public void setAgility(int agility) {
        Agility = agility;
    }


}
