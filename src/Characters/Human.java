package Characters;
import java.util.ArrayList;
import java.util.List;
import Colors.ColorsCodes;
import Items.*;

public class Human extends Character {
    private int EXP;
    private int MP;
    private int Dexterity;
    private int gold;

    private boolean ready;
    private int expNeeded;
    protected String Type;

    private int nowaHP;
    private int nowaMP;
    private int nowaStrength;
    private int nowaAgility;
    private int nowaDexterity;

    private List<Items> itemsList;
    private List<Weapon> weaponList;
    private List<Armory> armoryList;
    private List<Spell> spellList;
    private List<Potion> potionList;

    private List<Weapon> weaponsOnHand;
    private List<Armory> ArmoryOnBody;


    Human(String name, int HP, int Strength, int Agility ,int level, int EXP, int MP, int dexterity, int gold, String color) {
        super(name, level * 100, Strength, Agility, level, color);
        this.EXP = EXP;
        this.MP = MP;
        this.Dexterity = dexterity;
        this.gold = gold;
        this.ready = true;
        this.isAlive = true;

        this.nowaHP = HP;
        this.nowaMP = MP;
        this.nowaStrength = Strength;
        this.nowaAgility = Agility;
        this.nowaDexterity = dexterity;


        this.weaponsOnHand = new ArrayList<>();
        this.ArmoryOnBody = new ArrayList<>();

        this.itemsList  = new ArrayList<>();
        this.weaponList = new ArrayList<>();
        this.armoryList = new ArrayList<>();
        this.spellList = new ArrayList<>();
        this.potionList = new ArrayList<>();

        resetExpNeeded();
    }

    public Human(Human other){
        super(other);
        this.EXP = other.EXP;
        this.MP = other.MP;
        this.Dexterity = other.Dexterity;
        this.gold = other.gold;
        this.itemsList = new ArrayList<>(other.itemsList);
        this.weaponsOnHand = new ArrayList<>(other.weaponsOnHand);
        this.weaponList = new ArrayList<>(other.weaponList);
        this.armoryList = new ArrayList<>(other.armoryList);
        this.spellList = new ArrayList<>(other.spellList);
        this.potionList = new ArrayList<>(other.potionList);
        this.ArmoryOnBody = new ArrayList<>(other.ArmoryOnBody);
        this.ready = other.ready;
        this.isAlive = other.isAlive;

        this.nowaAgility = other.nowaAgility;
        this.nowaDexterity = other.nowaDexterity;
        this.nowaHP = other.nowaHP;
        this.nowaMP = other.nowaMP;
        this.nowaStrength = other.nowaStrength;

        resetExpNeeded();
    }

    public void printLevelUp(){
        System.out.println("You have leveled up! Now you are level " + this.getLevel());
        System.out.println("Now you need " + (this.getExpNeeded() - this.EXP) + " EXP to level up again.");
        System.out.println();
    }

    public void levelUp(){
        this.setLevel(this.getLevel()+1);
        this.setStrength((int)(this.getStrength() * 1.1));
        this.setAgility((int)(this.getAgility() * 1.1));
        this.setDexterity((int)(this.getDexterity() * 1.1));
        this.setMP((int)(this.getMP() * 1.1));
        this.setHP((int)(this.getHP() * 1.1));

        printLevelUp();
        this.resetExpNeeded();
    }

    @Override
    public String toString() {
        return String.format(
            "+----------------+----------------+\n" +
            "| Attribute      | Value          |\n" +
            "+----------------+----------------+\n" +
            "| NAME           | %-14s |\n" +
            "| HP             | %-14d |\n" +
            "| MP             | %-14d |\n" +
            "| EXP            | %-14d |\n" +
            "| Level          | %-14d |\n" +
            "| Agility        | %-14d |\n" +
            "| Strength       | %-14d |\n" +
            "| Dexterity      | %-14d |\n" +
            "| Gold           | %-14d |\n" +
            "+----------------+----------------+\n",
            this.getName(),
            this.getHP(),
            this.getMP(),
            this.getEXP(),
            this.getLevel(),
            this.getAgility(),
            this.getStrength(),
            this.getDexterity(),
            this.getGold()
        );
    }

    public void printNowaInformation(){
        String information = String.format(
                "+----------------+----------------+\n" +
                        "| Attribute      | Value          |\n" +
                        "+----------------+----------------+\n" +
                        "| NAME           | %-14s |\n" +
                        "| HP             | %-14d |\n" +
                        "| MP             | %-14d |\n" +
                        "| EXP            | %-14d |\n" +
                        "| Level          | %-14d |\n" +
                        "| Agility        | %-14d |\n" +
                        "| Strength       | %-14d |\n" +
                        "| Dexterity      | %-14d |\n" +
                        "| Gold           | %-14d |\n" +
                        "+----------------+----------------+\n",
                this.getName(),
                this.getNowaHP(),
                this.getNowaMP(),
                this.getEXP(),
                this.getLevel(),
                this.getNowaAgility(),
                this.getNowaStrength(),
                this.getNowaDexterity(),
                this.getGold()
        );
        System.out.println(information);
    }

    public void printBattleInformation(int index){
        System.out.printf("| %-27s | %-14d | %-14d | %-14d |\t%d%n",
                this.getName(), this.getNowaHP(), this.getNowaMP(), this.getStrength(), index);

    }

    public void resetNowaAttributes(){
        this.nowaStrength = this.getStrength();
        this.nowaAgility = this.getAgility();
        this.nowaDexterity = this.getDexterity();
    }

    protected void resetExpNeeded(){
        if(super.getLevel() == 1 ){
            this.expNeeded = 15;
        } else{
            this.expNeeded += (int) (this.expNeeded * 1.1);
        }
    }

    public void usePotion( Potion potion){
        List<String> attAffect = potion.getAttAffect();
        int attIncrease = potion.getAttIncrease();

        for( String att : attAffect ){
            switch(att){
                case "Strength":
                    this.nowaStrength += attIncrease;
                    break;
                case "Agility":
                    this.nowaAgility += attIncrease;
                    break;
                case "Dexterity":
                    this.nowaDexterity += attIncrease;
                    break;
                case "Health":
                    this.nowaHP = Math.min(this.nowaHP + attIncrease, this.getHP());
                    break;
                case "Mana":
                    this.nowaMP = Math.min(this.nowaMP + attIncrease, this.getMP());
                    break;
            }
        }
    }

    public boolean pickAWeapon(Weapon weapon){
        int handsNeeded = weapon.getRequiredHands();
        int handsInUse = 0;
        for( Weapon w : this.weaponsOnHand){
            handsInUse += w.getRequiredHands();
        }
        if( 2 < handsNeeded + handsInUse ){
            System.out.println("You cannot take this weapon, you have no enough hands");
            System.out.println("Your hands left: " + (2 - handsInUse));
            return false;
        } else{
            this.weaponsOnHand.add(weapon);
            return true;
        }
    }
    public boolean removeAWeaponFromHands(Weapon weapon){
        if( this.weaponsOnHand.contains(weapon)){
            this.weaponsOnHand.remove(weapon);
            return true;
        } else{
            return false;
        }
    }

    public boolean pickAnArmory(Armory armory){
        if(!this.ArmoryOnBody.isEmpty()){
            System.out.println("You cannot take this armory, you have no enough space");
            return false;
        } else{
            this.ArmoryOnBody.add(armory);
            return true;
        }
    }

    public boolean takeOffAnArmory(){
        if( !this.ArmoryOnBody.isEmpty()){
            this.ArmoryOnBody.remove(ArmoryOnBody.size() - 1);
            return true;
        } else{
            return false;
        }
    }


    public List<Weapon> getWeaponsOnHand() {
        return this.weaponsOnHand;
    }

    public void printArmoryORWeapon(){
        System.out.println(ColorsCodes.RED);
        System.out.println("Weapons:");
        System.out.println(Weapon.header);
        for( Items item : this.weaponList){
            if( item instanceof Weapon){
                System.out.println(item);
            }
        }
        System.out.println(ColorsCodes.RESET);

        System.out.println(ColorsCodes.GREEN);
        System.out.println("Armory:");
        System.out.println(Armory.header);
        for( Items item : this.armoryList){
            if( item instanceof Armory){
                System.out.println(item);
            }
        }
        System.out.println(ColorsCodes.RESET);
    }

    public void printOtherItems(){
        System.out.println(ColorsCodes.CYAN);
        System.out.println("Potions:");
        System.out.println(Potion.header);
        for( Items item : this.potionList){
            if( item instanceof Potion){
                System.out.println(item);
            }
        }
        System.out.println(ColorsCodes.RESET);

        System.out.println("Spells:");
        System.out.println(Spell.header);
        for( Items item : this.spellList){
            if( item instanceof Spell){
                System.out.println(item);
            }
        }
        System.out.println(ColorsCodes.RESET);
    }



    public boolean isReady() {
        return this.ready;
    }
    public void setReady( boolean ready ) {
        this.ready = ready;
    }


    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public void beAttacked( int damage ){
        this.nowaHP = Math.max(this.nowaHP - damage, 0);
        if( this.nowaHP == 0){
            this.isAlive = false;
        }
    }

    public void beRecoveredHP( int HP ){
        this.nowaHP = Math.min(this.nowaHP + HP, this.getHP());
    }
    public void useSpell(Spell spell){
        this.nowaMP = Math.max(this.nowaMP - spell.getManaCost(), 0);
    }
    public void beRecoveredMP( int MP ){
        this.nowaMP = Math.min(this.nowaMP + MP, this.getMP());
    }

    public  void addItem(Items item){
        itemsList.add(item);
        switch(item.getType()){
            case "Weapon":
                weaponList.add((Weapon)item);
                break;
            case "Armory":
                armoryList.add((Armory)item);
                break;
            case "Spell":
                spellList.add((Spell)item);
                break;
            case "Potion":
                potionList.add((Potion)item);
                break;

        }
    }

    public void deleteItem(Items item){
        itemsList.remove(item);
        switch(item.getType()){
            case "Weapon":
                weaponList.remove((Weapon)item);
                break;
            case "Armory":
                armoryList.remove((Armory)item);
                break;
            case "Spell":
                spellList.remove((Spell)item);
                break;
            case "Potion":
                potionList.remove((Potion)item);
                break;
        }
    }

    public void sellItem(Items item){
        this.gold += item.getPrice() / 2;
        this.deleteItem(item);
    }






    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getNowaHP() {
        return nowaHP;
    }

    public void setNowaHP(int nowaHP) {
        this.nowaHP = nowaHP;
    }

    public int getNowaMP() {
        return nowaMP;
    }

    public void setNowaMP(int nowaMP) {
        this.nowaMP = nowaMP;
    }

    public int getNowaStrength() {
        return nowaStrength;
    }

    public void setNowaStrength(int nowaStrength) {
        this.nowaStrength = nowaStrength;
    }

    public int getNowaAgility() {
        return nowaAgility;
    }

    public void setNowaAgility(int nowaAgility) {
        this.nowaAgility = nowaAgility;
    }

    public int getNowaDexterity() {
        return nowaDexterity;
    }

    public void setNowaDexterity(int nowaDexterity) {
        this.nowaDexterity = nowaDexterity;
    }

    public String getType(){
        return this.Type;
    }

    public List<Items> getItemsList() {
        return this.itemsList;
    }

    public int getExpNeeded() {
        return this.expNeeded;
    }

    public List<Spell> getSpellList() {
        return spellList;
    }

    public List<Armory> getArmoryList() {
        return armoryList;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public List<Potion> getPotionList() {
        return potionList;
    }

    public List<Armory> getArmoryOnBody() {
        return ArmoryOnBody;
    }

    public void setArmoryOnBody(List<Armory> armoryOnBody) {
        ArmoryOnBody = armoryOnBody;
    }
}
