package Items;
import tool.toolClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//store information of all types of items
public class ItemLists {

    List<Armory> armoryList = new ArrayList<>();
    List<Potion> potionList = new ArrayList<>();
    List<Spell> fireSpellList = new ArrayList<>();
    List<Spell> lightSpellList = new ArrayList<>();
    List<Spell> iceSpellList = new ArrayList<>();
    List<Weapon> weaponList = new ArrayList<>();

    public ItemLists(){
        loadArmoryList();
        loadPotionList();
        loadOneSpell("fire", "FireSpells");
        loadOneSpell("ice", "IceSpells");
        loadOneSpell("light", "LightningSpells");
        loadWeaponList();
    }

    private void loadArmoryList(){
        String filePath = "data/Armory.txt";
        List<String[]> datas = toolClass.loadData(filePath);
        for( String[] line : datas ){
            String name = line[0];
            int cost = Integer.parseInt(line[1]);
            int level = Integer.parseInt(line[2]);
            int damageReduction = Integer.parseInt(line[3]);
            Armory armory = new Armory(name, cost, level, damageReduction);
            armoryList.add(armory);
        }
    }

    private void loadPotionList(){
        String filePath = "data/Potions.txt";
        List<String[]> datas = toolClass.loadData(filePath);
        for( String[] line : datas ){
            String name = line[0];
            int cost = Integer.parseInt(line[1]);
            int level = Integer.parseInt(line[2]);
            int attributeIncrease = Integer.parseInt(line[3]);
            String attributes = line[4];
            List<String> attAffect = Arrays.asList(attributes.split("/"));
            Potion potion = new Potion(name, cost, level, attributeIncrease, attAffect);
            potionList.add(potion);
        }
    }

    private void loadOneSpell(String spellType, String fileName){
        String filePath = "data/"+ fileName +".txt";
        List<String[]> datas = toolClass.loadData(filePath);
        for( String[] line : datas ){
            String name = line[0];
            int cost = Integer.parseInt(line[1]);
            int level = Integer.parseInt(line[2]);
            int damage = Integer.parseInt(line[3]);
            int manaCost = Integer.parseInt(line[4]);

            if(spellType.equals("fire")){
                fireSpell firespell = new fireSpell("Spell", name, cost, level, damage, manaCost);
                fireSpellList.add(firespell);
            } else if(spellType.equals("light")){
                lightSpell lightspell = new lightSpell("Spell", name, cost, level, damage, manaCost);
                lightSpellList.add(lightspell);
            } else if(spellType.equals("ice")){
                iceSpell icespell = new iceSpell("Spell", name, cost, level, damage, manaCost);
                iceSpellList.add(icespell);
            }
        }
    }

    private void loadWeaponList(){
        String filePath = "data/Weaponry.txt";
        List<String[]> datas = toolClass.loadData(filePath);
        for( String[] line : datas ){
            String name = line[0];
            int cost = Integer.parseInt(line[1]);
            int level = Integer.parseInt(line[2]);
            int damage = Integer.parseInt(line[3]);
            int requiredHands = Integer.parseInt(line[4]);
            Weapon weapon = new Weapon(name, cost, level, damage, requiredHands);
            weaponList.add(weapon);
        }
    }

    public List<Armory> getArmoryList() {
        return armoryList;
    }

    public List<Potion> getPotionList() {
        return potionList;
    }

    public List<Spell> getFireSpellList() {
        return fireSpellList;
    }

    public List<Spell> getLightSpellList() {
        return lightSpellList;
    }

    public List<Spell> getIceSpellList() {
        return iceSpellList;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }
}
