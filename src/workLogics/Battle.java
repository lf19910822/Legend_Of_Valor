package workLogics;
import Characters.*;
import Colors.ColorsCodes;
import places.Piece;
import places.aMonster;
import places.common;
import places.herosGroup;
import tool.toolClass;
import Items.*;
import java.util.ArrayList;
import java.util.List;

public class Battle {
    CharacterMaps cmap;
    List<Monster> monsters;
    herosGroup herosgroup;
    aMonster singleMonster;


    int numberOfHeros;
    int recommendedMonsterLevel;
    int round;

    private Battle(herosGroup hg){
        cmap = new CharacterMaps();
        monsters = new ArrayList<>();
        this.herosgroup = hg;

        this.numberOfHeros = herosgroup.getGroup().size();
        this.recommendedMonsterLevel = Formulas.getMonsterLevel(hg);
        for( int i = 0 ; i < numberOfHeros; i++){
            Monster monster = new Monster(getAMonsterAtRandom());
            monster.initByLevel(recommendedMonsterLevel);
            this.monsters.add(monster);
        }
        this.round = 0;
    }

    public Battle(herosGroup hg, aMonster mp){
        cmap = new CharacterMaps();
        this.herosgroup = hg;
        Monster m = mp.getMonster();
        this.monsters = new ArrayList<>();
        this.monsters.add(m);
        this.singleMonster = mp;
    }

    public boolean singleBattleWorkFlow(){
        System.out.println("!!!Battle starts!!!");
        boolean quit = false;
        while(!quit){
            this.round++;
            System.out.println("Round " + this.round);
            printHerosAndMonsters();

            for( Human hero : this.herosgroup.getGroup()){
                if( hero.isAlive()){
                    System.out.println("Now is hero " + hero.getName() + "'s turn");
                    oneHeroActions(hero);
                    printMonsters();
                    if( checkWin() ){
                        System.out.println("All monsters are dead! heroes win!");
                        quit = true;
                        break;
                    }
                }
            }

            if(!quit)
                toolClass.pauseFlow();

            for( Monster monster : this.monsters ){
                if( monster.isAlive()) {
                    Human hero = pickAHeroAtRandom();
                    System.out.println("Now is monster " + monster.getName() + "'s turn");
                    humanBeAttacked(monster, hero);
                    printHeros();
                    if (checkFail()) {
                        System.out.println("All heroes are in faint!");
                        return false;
                    }
                }
            }

            if(!quit)
                toolClass.pauseFlow();
        }

        endBattle();
        return true;
    }

    public Piece heroStartFlow(){     // if there is a result(human or monster wins), return it;
        Piece noWinner = new common( 0, 0, 0);// or return a common piece
        singleHeroAction();
        singleMonsterAttack();
        if( checkWin()  ){
            return this.herosgroup;
        }
        if( checkFail() ){
            return this.singleMonster;
        }
        return noWinner;
    }

    public Piece monsterStartFlow(){
        Piece noWinner = new common( 0, 0, 0);
        singleMonsterAttack();
        if( checkFail() )
            return this.singleMonster;
        singleHeroAction();
        if( checkWin() ){
            return this.herosgroup;
        }
        return noWinner;
    }

    public void singleHeroAction(){
        Human hero = this.herosgroup.getGroup().get(0);
        oneHeroActions(hero);
        System.out.println("Hero " + hero.getName() + " finished his turn");
        toolClass.pauseFlow();
    }

    public void singleMonsterAttack(){
        if(this.monsters.isEmpty())
            return;
        Monster monster = this.monsters.get(0);
        if( monster.isAlive()) {
            Human hero = this.herosgroup.getGroup().get(0);
            System.out.println("Now is monster " + monster.getName() + "'s turn");
            humanBeAttacked(monster, hero);
            printHeros();
            if (checkFail()) {
                System.out.println("Hero is in faint!");
            }
        }
        System.out.println("Monster " + monster.getName() + " finished his turn");
        toolClass.pauseFlow();
    }


//    public boolean battleWorkFlow(){
//        System.out.println("!!!Battle starts!!!");
//        boolean quit = false;
//        while(!quit){
//            this.round++;
//            System.out.println("Round " + this.round);
//            printHerosAndMonsters();
//
//            for( Human hero : this.herosgroup.getGroup()){
//                if( hero.isAlive()){
//                    System.out.println("Now is hero " + hero.getName() + "'s turn");
//                    oneHeroActions(hero);
//                    printMonsters();
//                    if( checkWin() ){
//                        System.out.println("All monsters are dead! heroes win!");
//                        quit = true;
//                        break;
//                    }
//                }
//            }
//
//            if(!quit)
//                toolClass.pauseFlow();
//
//            for( Monster monster : this.monsters ){
//                if( monster.isAlive()) {
//                    Human hero = pickAHeroAtRandom();
//                    System.out.println("Now is monster " + monster.getName() + "'s turn");
//                    humanBeAttacked(monster, hero);
//                    printHeros();
//                    if (checkFail()) {
//                        System.out.println("All heroes are in faint!");
//                        return false;
//                    }
//                }
//            }
//
//            if(!quit)
//                toolClass.pauseFlow();
//        }
//
//        endBattle();
//        return true;
//    }

    public void printHerosAndMonsters(){
        printHeros();
        System.out.println();
        printMonsters();
    }

    public void printHeros(){
        int count = 0;
        System.out.println("Heros: ");
        System.out.println("+--------------------+----------------+----------------+----------------+");
        System.out.println("| Name               | HP             | MP             | Damage         |");
        System.out.println("+--------------------+----------------+----------------+----------------+");
        for(Human hero: herosgroup.getGroup()){
            if( hero.isAlive()){
                count++;
                hero.printBattleInformation(count);
            }
        }
        System.out.println("+--------------------+----------------+----------------+----------------+");
    }


    public void printMonsters(){
        int count = 0;
        System.out.println("Monsters: ");
        System.out.println("+--------------------+----------------+----------------+----------------+----------------+");
        System.out.println("| Name               | Type           | HP             | Defense        | Dodge          |");
        System.out.println("+--------------------+----------------+----------------+----------------+----------------+");
        for(Monster monster: monsters){
            monster.printAttackInformation(count);
            count++;
        }
        System.out.println("+--------------------+----------------+----------------+----------------+----------------+");

    }

    public void printPotion(Human hero) {
        List<Potion> potions = hero.getPotionList();
        int count = 0;
        System.out.println(ColorsCodes.CYAN);
        System.out.println(Potion.header);
        for( Potion potion : potions){
            System.out.println(potion.toString() + "\t" + count);
            count++;
        }
        System.out.println(ColorsCodes.RESET);
    }

    public boolean selectAndUseAPotion(Human hero){
        printPotion(hero);
        if(hero.getPotionList().isEmpty()){
            System.out.println("Hero " + hero.getName() + " has no potion available");
            toolClass.pauseFlow();
            return false;
        }
        System.out.println("Choose a potion to use, or type 'q' to quit");
        String input = toolClass.scanner.nextLine();
        if( input.equals("q")){
            return false;
        } else if( toolClass.checkInput(input, 0, hero.getPotionList().size() - 1)){
            int index = Integer.parseInt(input);
            Potion potion = hero.getPotionList().get(index);
            hero.usePotion(potion);
            System.out.println("Hero " + hero.getName() + " used potion " + potion.getName());
            hero.printNowaInformation();
            hero.deleteItem(potion);
            return true;
        }
        return false;
    }

    private void endBattle(){
        System.out.println("Battle ends!");
        System.out.println("All heroes regain HP and MP:");
        Formulas.regainAfterWin(this.herosgroup, 0.2);
        int gold = Formulas.gainGoldAfterWin(this.herosgroup, this.recommendedMonsterLevel, 100);
        int exp = Formulas.gainEXPAfterWin(this.herosgroup, this.recommendedMonsterLevel, 5);

        System.out.println("All heroes not in faint gain: " + gold + " gold and " + exp + " EXP!");

        for( Human hero : this.herosgroup.getGroup()){
            if( !hero.isAlive() ){
                hero.setAlive(true);
                System.out.println( hero.getName() + " is revived with half HP and MP!");
            }
            hero.resetNowaAttributes();
            hero.getArmoryOnBody().clear();
            hero.getWeaponsOnHand().clear();
        }
        toolClass.pauseFlow();
    }

    public void endSingleBattle(){
        System.out.println("The monster is defeated!");
        System.out.println("Hero regains HP and MP:");
        Formulas.regainAfterWin(this.herosgroup, 0.2);
        this.recommendedMonsterLevel = this.singleMonster.getMonster().getLevel();
        int gold = Formulas.gainGoldAfterWin(this.herosgroup, this.recommendedMonsterLevel, 100);
        int exp = Formulas.gainEXPAfterWin(this.herosgroup, this.recommendedMonsterLevel, 5);

        System.out.println("Hero gains: " + gold + " gold and " + exp + " EXP!");
//        System.out.println("All heroes not in faint gain: " + gold + " gold and " + exp + " EXP!");

//        for( Human hero : this.herosgroup.getGroup()){
//            if( !hero.isAlive() ){
//                hero.setAlive(true);
//                System.out.println( hero.getName() + " is revived with half HP and MP!");
//            }
////            hero.resetNowaAttributes();
////            hero.getArmoryOnBody().clear();
////            hero.getWeaponsOnHand().clear();
//        }
        toolClass.pauseFlow();
    }

    public void endFailedBattle(){
        Human hero = this.herosgroup.getGroup().get(0);
        System.out.println("Hero " + hero.getName() + " is defeated! He will reborn in the Nexus!");
//        hero.setAlive(true);
        toolClass.pauseFlow();
    }

    private void oneHeroActions( Human human ){
        boolean quit = false;
        Monster monster = null;
        while(!quit){
            System.out.println("1  regular attack\n2  spell attack\n3  show hero's information\n" +
                    "4  Do nothing");
            int input = toolClass.getAnIntInput(1,6);
            if( input == -1 )
                continue;

            switch (input){
                case 1:
                    monster = chooseAMonster();
                    if(regularHumanAttack(monster, human))
                        quit = true;
                    continue;
                case 2:
                    printSpells(human);
                    System.out.println("Choose a spell to attack, or type 'q' to quit");
                    String spellInput = toolClass.scanner.nextLine();
                    if( spellInput.equals("q")){
                        continue;
                    } else if( toolClass.checkInput(spellInput, 0, human.getSpellList().size() - 1)){
                        int index = Integer.parseInt(spellInput);
                        Spell spell = human.getSpellList().get(index);
                        monster = chooseAMonster();
                        if(spellHumanAttack(monster, human, spell))
                            quit = true;
                    }
                    break;
                case 3:
                    human.printNowaInformation();
                    continue;
                case 4:
                    quit = true;
                    break;
//                case 5:
//                    selectAndUseAPotion(human);
//                    if( selectAndUseAPotion(human) )
//                        quit = true;
//                    break;
//
//                case 6:
//
//                    break;
            }
            break;
        }
    }

    public Monster chooseAMonster(){
        int numberOfMonsters = this.monsters.size();
        while(true){
            printMonsters();
            if(numberOfMonsters==1)
                return this.monsters.get(0);
            System.out.println("Choose a monster by index to attack");
            int input = toolClass.getAnIntInput(0, numberOfMonsters - 1);
            if( input == -1 )
                continue;
            return this.monsters.get(input);
        }

    }

    private void humanBeAttacked( Monster monster, Human human ){
        System.out.println("Monster " + monster.getName() + " is attacking hero " + human.getName());
        int damage = monster.getStrength();
        damage = Formulas.getDamageOnHuman(human, damage, 0.8);
        if( damage == -1){
            System.out.println("Hero " + human.getName() + " dodged the attack");
            return;
        }
        System.out.println("Monster " + monster.getName() + " attacked " + human.getName() + " with " +
                ColorsCodes.RED + damage + ColorsCodes.RESET + " damage");
        human.beAttacked(damage);
        if( !human.isAlive() ){
            System.out.println("Hero " + human.getName() + " is in faint!");
        }
    }

    private int beforeAttack(Monster monster, Human human, int damage){
        damage = Formulas.getDamageOnMonster(monster, damage, 0.2);
        boolean askResult = askForAttack(damage, 1 - Formulas.getMonsterDodgeChance(monster), human, monster);
        double dodge = Formulas.getMonsterDodgeChance(monster);
        if( !askResult )
            return 0;
        if( toolClass.Dice(dodge)){
            System.out.println("Monster " + monster.getName() + " dodged the attack");
            return 1;
        }
        return 2;
    }


    private boolean regularHumanAttack( Monster monster, Human human ){
        int damage = Formulas.getAttackDamageWithWeapon(human, 0.5);
        switch (beforeAttack(monster, human, damage)) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                break;
        }
        damage = Formulas.getDamageOnMonster(monster, damage, 0.2);
        System.out.println("Hero " + human.getName() + " attacked " + monster.getName() + " with " +
                ColorsCodes.RED + damage + ColorsCodes.RESET + " damage");
        monster.beAttacked(damage);
        if( !monster.isAlive()){
            System.out.println("Monster " + monster.getName() + " is dead!");
            this.monsters.remove(monster);
        }
        return true;
    }

    private boolean spellHumanAttack( Monster monster, Human human, Spell spell ){
        if( human.getMP() < spell.getManaCost() ){
            System.out.println("Hero " + human.getName() + " has no enough MP to use this spell");
            toolClass.pauseFlow();
            return false;
        }
        human.useSpell(spell);
        int damage = Formulas.spellDamageForm(spell, human, 10000);
        switch (beforeAttack(monster, human, damage)) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                break;
        }
        System.out.println("Hero " + human.getName() + " use " + spell.getName() + " on " + monster.getName() +
                " with " + ColorsCodes.RED + damage + ColorsCodes.RESET + " damage");
        System.out.println("The spell weaken the monster!");
        monster.beAttacked(damage, spell);
        if( !monster.isAlive()){
            System.out.println("Monster " + monster.getName() + " is dead!");
            this.monsters.remove(monster);
        }
//        human.deleteItem(spell);
        return true;
    }


//    private boolean pickArmoryOrWeaponByOneHero(Human hero){
//        List<Items> ArmoryOrWeapon = new ArrayList<>();
//        ArmoryOrWeapon.addAll(hero.getWeaponList());
//        ArmoryOrWeapon.addAll(hero.getArmoryList());
//        if( ArmoryOrWeapon.size() <= 0 ){
//            System.out.println("Hero " + hero.getName() + " has no weapon or armory available");
//            toolClass.pauseFlow();
//            return false;
//        }
//
//
//        boolean quit = false;
//        printArmoryAndWeapon(ArmoryOrWeapon);
//        while(!quit){
//            System.out.println("Choose an item to pick, or type 'q' to quit");
//            String input = toolClass.scanner.nextLine();
//            if( input.equals("q")){
//                return false;
//            } else if( toolClass.checkInput(input, 0, ArmoryOrWeapon.size() - 1)){
//                int index = Integer.parseInt(input);
//                Items item = ArmoryOrWeapon.get(index);
//
//                if( item instanceof Weapon){
//                    if(hero.pickAWeapon((Weapon) item)){
//                        ArmoryOrWeapon.remove(item);
//                        System.out.println("Hero " + hero.getName() + " picked weapon " + item.getName());
//                    }
//                } else if( item instanceof Armory){
//                    if(hero.pickAnArmory((Armory) item)){
//                        ArmoryOrWeapon.remove(item);
//                        System.out.println("Hero " + hero.getName() + " picked armory " + item.getName());
//                    }
//                }
//                return true;
//            }
//        }
//        return false;
//    }

    private void printSpells(Human hero){
        int count = 0;
        System.out.println(ColorsCodes.PURPLE);
        System.out.println(Spell.header);
        for( Spell spell : hero.getSpellList()){
            System.out.println(spell.toString() + "\t" + count);
            count++;
        }
        System.out.println(ColorsCodes.RESET);
    }

//    private void printArmoryAndWeapon(List<Items> ArmoryOrWeapon){
//        System.out.println(ColorsCodes.RED);
//        System.out.println("Weapons:");
//        System.out.println(Weapon.header);
//        for( Items item : ArmoryOrWeapon){
//            if( item instanceof Weapon){
//                System.out.println(item + "\t" + ArmoryOrWeapon.indexOf(item));
//            }
//        }
//        System.out.println(ColorsCodes.RESET);
//
//        System.out.println(ColorsCodes.GREEN);
//        System.out.println("Armories:");
//        System.out.println(Armory.header);
//        for( Items item : ArmoryOrWeapon){
//            if( item instanceof Armory){
//                System.out.println(item + "\t" + ArmoryOrWeapon.indexOf(item));
//            }
//        }
//        System.out.println(ColorsCodes.RESET);
//    }



    private Monster getAMonsterAtRandom(){
        int random = toolClass.getRandomNumber(1, 3);
        switch (random){
            case 1:
                return getADragonAtRandom();
            case 2:
                return getAnExoAtRandom();
            case 3:
                return getASpiritAtRandom();
            default:
                return null;
        }
    }

    private void printAttackInformation(int damage, double hitRate, Human attacker, Monster monster) {
        System.out.println("+--------------------+--------------------+----------------+----------------+");
        System.out.println("| Attacker           | Monster            | Damage         | Hit Rate       |");
        System.out.println("+--------------------+--------------------+----------------+----------------+");
        System.out.printf("| %-27s | %-27s | %-14d | %-14.2f |%n",
                attacker.getName(), monster.getName(), damage, hitRate);
        System.out.println("+--------------------+--------------------+----------------+----------------+");
    }

    private boolean askForAttack(int damage, double hitRate, Human attacker, Monster monster){
        printAttackInformation(damage, hitRate, attacker, monster);
        System.out.println("Are you sure to attack? 1  Yes  0  No");
        int input = toolClass.getAnIntInput(0, 1);
        return input == 1;
    }

    private boolean checkFail(){
        for( Human hero : this.herosgroup.getGroup() ){
            if( hero.isAlive() )
                return false;
        }
        return true;
    }

    private boolean checkWin(){
        for( Monster monster : this.monsters ){
            if( monster.isAlive() )
                return false;
        }
        return true;
    }

    private Human pickAHeroAtRandom(){
        List<Human> herosAlive = new ArrayList<>();
        for( Human hero : herosgroup.getGroup()){
            if( hero.isAlive()){
                herosAlive.add(hero);
            }
        }
        return toolClass.getRandomValueFromList(herosAlive);
    }


    private Monster getADragonAtRandom(){
        return toolClass.getRandomValueFromMap(cmap.getDragonMap());
    }
    private Monster getAnExoAtRandom(){
        return toolClass.getRandomValueFromMap(cmap.getExoMap());
    }
    private Monster getASpiritAtRandom(){
        return toolClass.getRandomValueFromMap(cmap.getSpiritsMap());
    }

    public static Battle getABattle(herosGroup hg){
        return new Battle(hg);
    }

}
