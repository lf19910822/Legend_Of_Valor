package workLogics;
import Characters.*;
import Items.Armory;
import Items.Spell;
import Items.Weapon;
import places.herosGroup;
import tool.toolClass;

//The class of most formulas. We calculate the damage, dodge chance, Exp and Gold after battle …… in this class.
//Most of formulas are able to accept different multiply powering to fit in different logics.
public class Formulas {
    Formulas(){
    }

    public static int spellDamageForm(Spell spell, Human attacker, double multi ){
        return (int)(spell.getDamage() + (attacker.getNowaDexterity() / multi) * spell.getDamage()); // 10000
    }
    public static int getAttackDamageWithWeapon(Human attacker, double multi){
        int weaponsDamage = 0;
        for(Weapon weapon : attacker.getWeaponsOnHand()){
            weaponsDamage += weapon.getDamage(); // 0.05
        }
        return (int)((attacker.getNowaStrength() + weaponsDamage * multi) ); // 0.05
    }
    public static double getHumanDodgeChance(Human human){
        return (human.getNowaAgility() * 0.0005);
    }
    public static double getMonsterDodgeChance(Monster monster){
        return (monster.getAgility() * 0.005);
    }

    public static void regainAfterWin(herosGroup hg, double multi){
        for( Human human : hg.getGroup()){
            if( human.isAlive()){
                int regainHP = (int)(human.getHP() * multi);    // 0.2
                human.setNowaHP(Math.min(human.getNowaHP() + regainHP, human.getHP()));

                int regainMP = (int)(human.getMP() * multi);    // 0.2
                human.setNowaMP(Math.min(human.getNowaMP() + regainMP, human.getMP()));
                System.out.println(human.getName() + " regained " + regainHP + " HP and " + regainMP + " MP.");
            } else{
                human.setNowaHP(human.getHP() / 2 );
                human.setNowaMP(human.getMP() / 2 );
                System.out.println(human.getName() + " regained " + human.getHP() / 2 + " HP and " + human.getMP() / 2 + " MP.");
            }
        }
    }

    public static int gainGoldAfterWin(herosGroup hg, int monsterLevel, double multi){
        double goldResult = monsterLevel * multi;
        for( Human human : hg.getGroup()){
            if( human.isAlive()){
                human.setGold( (int)(human.getGold() + goldResult) ); // 100
            }
        }
        return (int) goldResult;
    }

    public static int gainEXPAfterWin(herosGroup hg, int monsterLevel, double multi){
        double EXPResult = monsterLevel * multi;
        for( Human human : hg.getGroup()){
            if( human.isAlive() ){
                human.setEXP( (int)(human.getEXP() + EXPResult) ); // 0.5
                while( human.getEXP() >= human.getExpNeeded()){
                    human.levelUp();
                }
            }
        }
        return (int) EXPResult;
    }

    public static int getDamageOnMonster(Monster monster, int damage, double multi){
        damage = Math.max((int)(damage - monster.getDefense() * multi), 0); // 0.2
        return damage;
    }

    public static int getDamageOnHuman(Human human, int damage, double multi){
        if( !human.getArmoryOnBody().isEmpty() ){
            Armory armory = human.getArmoryList().get(0);
            damage = Math.max( (int)(damage - armory.getDamageReduction() * multi), 0); // 0.8
        }
        double dodge = Formulas.getHumanDodgeChance(human);
        if(toolClass.Dice(dodge)){
            return -1;
        }
        return damage;
    }

    public static void MonsterSkillLose(Monster monster, Spell spell, double multi){
        if( spell.getSpellType().equals("fire")){
            monster.setDefense( (int)(monster.getDefense() * multi)); // 0.2
        } else if( spell.getSpellType().equals("ice")){
            monster.setStrength( (int)(monster.getStrength() * multi)); // 0.2
        } else if( spell.getSpellType().equals("light")){
            monster.setAgility( (int)(monster.getAgility() * multi)); // 0.2
        }
    }

    public static int getMonsterLevel(herosGroup herosGroup){
        int level = 0;
        for(Human human : herosGroup.getGroup()){
            level += human.getLevel();
        }
        return level / herosGroup.getGroup().size();
    }

}
