package Characters;
import tool.toolClass;
import java.util.HashMap;
import java.util.List;

public class CharacterMaps {

    // Monsters
    private HashMap<String, Monster> dragonMap = new HashMap<>();
    private HashMap<String, Monster> ExoMap = new HashMap<>();
    private HashMap<String, Monster> SpiritsMap = new HashMap<>();

    // Humans
    private HashMap<String, Human> warriorMap = new HashMap<>();
    private HashMap<String, Human> paladinMap = new HashMap<>();
    private HashMap<String, Human> sorcererMap = new HashMap<>();


    public CharacterMaps() {
        loadAllMonsterMaps();
        loadAllHumanMaps();
    }

    private void loadAllMonsterMaps(){
        String filePath = "data\\Dragons.txt";
        loadOneMonsterMap(filePath, dragonMap, "dragon");

        filePath = "data\\Exoskeletons.txt";
        loadOneMonsterMap(filePath, ExoMap, "exoskeletons");

        filePath = "data\\Spirits.txt";
        loadOneMonsterMap(filePath, SpiritsMap, "spirits");

    }

    private void loadAllHumanMaps(){
        String filePath = "data\\Warriors.txt";
        loadOneHumanMap(filePath, warriorMap, "Warrior");

        filePath = "data\\Paladins.txt";
        loadOneHumanMap(filePath, paladinMap, "Paladin");

        filePath = "data\\Warriors.txt";
        loadOneHumanMap(filePath, sorcererMap, "Sorcerer");
    }

    private void loadOneMonsterMap( String path, HashMap<String, Monster> map, String monsterType){
        List<String[]> datas = toolClass.loadData(path);
        for( String[] line : datas ){
            String name = line[0];
            Monster monster = createMonsterInstanceByLine(line, monsterType);
            map.put(name, monster);
        }
    }

    private void loadOneHumanMap( String path, HashMap<String, Human> map, String career){
        List<String[]> datas = toolClass.loadData(path);
        for( String[] line : datas ){
            String name = line[0];
            Human human = createHumanInstanceByLine(line, career);
            map.put(name, human);
        }
    }

    private Monster createMonsterInstanceByLine(String[] line, String monsterType){
        String name = line[0];
        int HP = Integer.parseInt(line[1]);
        int level = Integer.parseInt(line[2]);
        int damage = Integer.parseInt(line[3]);
        int defense = Integer.parseInt(line[4]);
        int dodge = Integer.parseInt(line[5]);

        Monster monster = new Monster(name, HP, level, damage, defense, dodge, monsterType);
        return monster;
    }


    private Human createHumanInstanceByLine(String[] line, String career){
        String name = line[0];
        int HP = Integer.parseInt(line[1]);
        int MP = Integer.parseInt(line[2]);
        int Strength = Integer.parseInt(line[3]);
        int Agility = Integer.parseInt(line[4]);
        int dexterity = Integer.parseInt(line[5]);
        int gold = Integer.parseInt(line[6]);
        int EXP = Integer.parseInt(line[7]);
        int level = 1;

        if( career.equals("Warrior")){
            return new Warriors(name, HP, Strength, Agility, level, EXP, MP, dexterity, gold);
        } else if( career.equals("Paladin")){
            return new Paladin(name, HP, Strength, Agility, level, EXP, MP, dexterity, gold);
        } else if( career.equals("Sorcerer")){
            return new Sorcerer(name, HP, Strength, Agility, level, EXP, MP, dexterity, gold);
        }
        return null;
    }



    public HashMap<String, Monster> getDragonMap() {
        return dragonMap;
    }

    public HashMap<String, Monster> getExoMap() {
        return ExoMap;
    }

    public HashMap<String, Monster> getSpiritsMap() {
        return SpiritsMap;
    }


    public HashMap<String, Human> getWarriorMap() {
        return warriorMap;
    }

    public HashMap<String, Human> getPaladinMap() {
        return paladinMap;
    }

    public HashMap<String, Human> getSorcererMap() {
        return sorcererMap;
    }
}
