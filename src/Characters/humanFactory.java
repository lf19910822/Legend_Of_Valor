package Characters;

import tool.toolClass;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class humanFactory {
    private static humanFactory instance = null;

    public HashMap<String, Human>  getMapByHeroType(String heroType ){
        String filePath = "data/" + heroType + ".txt";
        File file = new File(filePath);

        if( !file.exists() ){
            System.out.println("missing data:" + filePath);
            return null;
        }
        HashMap<String, Human> map = new HashMap<>();
        loadOneHumanMap(filePath, map, heroType);

        return map;
    }

    private void loadOneHumanMap( String path, HashMap<String, Human> map, String career){
        List<String[]> datas = toolClass.loadData(path);
        for( String[] line : datas ){
            String name = line[0];
            Human human = createHumanInstanceByLine(line, career);
            map.put(name, human);
        }
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

        if( career.equals("Warriors")){
            return new Warriors(name, HP, Strength, Agility, level, EXP, MP, dexterity, gold);
        } else if( career.equals("Paladins")){
            return new Paladin(name, HP, Strength, Agility, level, EXP, MP, dexterity, gold);
        } else if( career.equals("Sorcerers")){
            return new Sorcerer(name, HP, Strength, Agility, level, EXP, MP, dexterity, gold);
        }
        return null;
    }


    public static humanFactory getInstance() {
        if (instance == null) {
            instance = new humanFactory();
        }
        return instance;
    }
}
