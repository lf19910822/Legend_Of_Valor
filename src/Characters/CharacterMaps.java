package Characters;
import tool.toolClass;
import java.util.HashMap;
import java.util.List;


//The class of all characters loaded from .txt file. We put all heroes and monsters in their own Map. As a result,
//we have three maps for different monsters and three for heroes. All data from .txt files will be checked and
//distinguished automatically.
public class CharacterMaps {
    // Monsters
    private HashMap<String, Monster> dragonMap = new HashMap<>();
    private HashMap<String, Monster> ExoMap = new HashMap<>();
    private HashMap<String, Monster> SpiritsMap = new HashMap<>();

    // Humans
    private HashMap<String, Human> warriorMap = new HashMap<>();
    private HashMap<String, Human> paladinMap = new HashMap<>();
    private HashMap<String, Human> sorcererMap = new HashMap<>();

    // humanFactory
    private humanFactory humanfactory;


    public CharacterMaps() {
        this.humanfactory = humanFactory.getInstance();
        loadAllMonsterMaps();
        loadAllHumans();
//        loadAllHumanMaps();
    }

    private void loadAllMonsterMaps(){
        String filePath = "data/Dragons.txt";
        loadOneMonsterMap(filePath, dragonMap, "dragon");

        filePath = "data/Exoskeletons.txt";
        loadOneMonsterMap(filePath, ExoMap, "exoskeletons");

        filePath = "data/Spirits.txt";
        loadOneMonsterMap(filePath, SpiritsMap, "spirits");
    }

    public void loadAllHumans(){
        HashMap<String, Human> humanMap;
        this.warriorMap = this.humanfactory.getMapByHeroType("Warriors");
        this.paladinMap = this.humanfactory.getMapByHeroType("Paladins");
        this.sorcererMap = this.humanfactory.getMapByHeroType("Sorcerers");
    }


    private void loadOneMonsterMap( String path, HashMap<String, Monster> map, String monsterType){
        List<String[]> datas = toolClass.loadData(path);
        for( String[] line : datas ){
            String name = line[0];
            Monster monster = createMonsterInstanceByLine(line, monsterType);
            map.put(name, monster);
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
