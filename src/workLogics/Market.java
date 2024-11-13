package workLogics;
import Characters.Human;
import Colors.ColorsCodes;
import Items.*;
import tool.toolClass;
import java.util.ArrayList;
import java.util.List;

public class Market {
    ItemLists lists = new ItemLists();

    List<Armory> marketArmory = new ArrayList<>();
    List<Potion> marketPotion = new ArrayList<>();
    List<Weapon> marketWeapon = new ArrayList<>();
    List<Spell> marketSpell = new ArrayList<>();


    private Market(){
        // load Armory
        for( Armory armory : lists.getArmoryList()){
            if(toolClass.Dice(0.8)){
                marketArmory.add(armory);
            }
        }
        // load Potion
        for( Potion Potion : lists.getPotionList()){
            if(toolClass.Dice(0.8)){
                marketPotion.add(Potion);
            }
        }
        // load Weapon
        for( Weapon Weapon : lists.getWeaponList()){
            if(toolClass.Dice(0.8)){
                marketWeapon.add(Weapon);
            }
        }
        // load four Spells
        for( Spell fireSpell : lists.getFireSpellList()){
            if(toolClass.Dice(0.6)){
                marketSpell.add(fireSpell);
            }
        }
        for( Spell iceSpell : lists.getIceSpellList()){
            if(toolClass.Dice(0.8)){
                marketSpell.add(iceSpell);
            }
        }
        for( Spell lightSpell : lists.getLightSpellList()){
            if(toolClass.Dice(0.8)){
                marketSpell.add(lightSpell);
            }
        }
    }

    public void marketWorkFlow( Human buyer ){
        System.out.println("Please pick what you want:");
        boolean quit = false;
        boolean mainQuit = false;
        while(!quit){
            System.out.println(buyer.getName() + "'s gold is: " + buyer.getGold());
            System.out.println(ColorsCodes.YELLOW + "1. Armory" + ColorsCodes.RESET);
            System.out.println(ColorsCodes.RED + "2. Weapon" + ColorsCodes.RESET);
            System.out.println(ColorsCodes.BLUE + "3. Potion" + ColorsCodes.RESET);
            System.out.println(ColorsCodes.CYAN + "4. Spell" + ColorsCodes.RESET);
            System.out.println("5. Quit");


            int choice = toolClass.getAnIntInput(1, 5);
            if( choice == -1 )
                continue;

            switch (choice) {
                case 1:
                    System.out.println("You chose Armory!");
                    printArmorys(ColorsCodes.YELLOW);
                    buyOneItemFlow(marketArmory, buyer);
                    break;
                case 2:
                    System.out.println("You chose Weapon!");
                    printWeapons(ColorsCodes.RED);
                    buyOneItemFlow(marketWeapon, buyer);
                    break;
                case 3:
                    System.out.println("You chose Potion!");
                    printPotions(ColorsCodes.CYAN);
                    buyOneItemFlow(marketPotion, buyer);
                    break;
                case 4:
                    System.out.println("You chose Spell!");
                    printSpells(ColorsCodes.PURPLE);
                    buyOneItemFlow(marketSpell, buyer);
                    break;
                case 5:
                    mainQuit = true;
                    break;
            }

            if( mainQuit )
                break;

            System.out.println("Want to buy again? 1    YES, 0    NO and quit");
            choice = toolClass.getAnIntInput(0, 1);
            if( choice != 1 ){
                quit = true;
            }
        }

        System.out.println("Do you want to sell your items? 1 YES, 0 NO and quit");
        int choice = toolClass.getAnIntInput(0, 1);
        if( choice == 1 ){
            sellItemsFlow(buyer);
        }

        System.out.println("See you again!");
        toolClass.pauseFlow();


    }

    private void buyOneItemFlow(List<? extends Items> itemList, Human buyer){
        boolean quit = false;
        while(!quit){
            int itemLength = itemList.size();
            System.out.println("Please type the index of the item you want to buy");
            int choice = toolClass.getAnIntInput(0, itemLength - 1);
            if( choice == -1 )
                continue;

            if( buy(buyer, itemList.get(choice)) ){
                System.out.println(buyer.getName() + " bought the item " + itemList.get(choice).getName());
                System.out.println("Now he has " + buyer.getGold() + "gold left");
                itemList.remove(choice);
                quit = true;
            } else{ // Only failed to buy one thing can get here. The marketList will not change
                System.out.println("Want to try again?  1   yes, 0    No");
                choice = toolClass.getAnIntInput(0, 1);
                if( choice != 1 ){
                    quit = true;
                }
            }


        }
    }

    private void sellItemsFlow(Human seller){
        boolean quit = false;
        while(!quit){
            int numberOfItems = seller.getItemsList().size();
            if( numberOfItems == 0 ){
                System.out.println("You have no items to sell");
                break;
            }
            int count = 0;
            System.out.println(Items.sellingHeader);
            for( Items items : seller.getItemsList()){
                items.printSellingInformation(count);
                count++;
            }

            System.out.println("Please type the index of the item you want to sell");
            int choice = toolClass.getAnIntInput(0, count);
            if( choice == -1 )
                continue;
            Items soldItem = seller.getItemsList().get(choice);
            sell(seller, soldItem);
            System.out.println(seller.getName() + " sold the item " + soldItem.getName());
            System.out.println("Now he has " + ColorsCodes.YELLOW + seller.getGold() + ColorsCodes.RESET + "gold left");

            System.out.println("Want to sell again? 1    YES, 0    NO and quit");
            choice = toolClass.getAnIntInput(0, 1);
            if( choice != 1 ){
                quit = true;
            }
        }
    }

    private boolean buy(Human buyer, Items item){
        int price = item.getPrice();
        int gold = buyer.getGold();

        if(price > gold ){
            System.out.println("Your gold is not enough");
            return false;
        } else{
            buyer.addItem(item);
            buyer.setGold(buyer.getGold() - price);
            return true;
        }
    }

    private void sell(Human seller, Items item){
        int price = item.getPrice();
        seller.sellItem(item);
    }


    public static Market getMarket(){
        return new Market();
    }


    public void printItems(){
        printArmorys(ColorsCodes.YELLOW);
        printWeapons(ColorsCodes.RED);
        printPotions(ColorsCodes.CYAN);
        printSpells(ColorsCodes.PURPLE);
    }

    private void printArmorys(String color){
        System.out.println(color);
        System.out.println("ARMORYS");
        System.out.println(Armory.header);
        int i = 0;
        for( Armory armory : marketArmory){
            System.out.println(armory + "" + i);
            i++;
        }
        System.out.println(ColorsCodes.RESET);
    }
    private void printPotions(String color){
        System.out.println(color);
        System.out.println("POTIONS");
        System.out.println(Potion.header);
        int i = 0;
        for( Potion potion : marketPotion){
            System.out.println(potion +""+ i);
            i++;
        }
        System.out.println(ColorsCodes.RESET);
    }
    private void printWeapons(String color){
        System.out.println(color);
        System.out.println("Weapons");
        System.out.println(Weapon.header);
        int i = 0;
        for( Weapon weapon : marketWeapon){
            System.out.println(weapon + "" + i);
            i++;
        }
        System.out.println(ColorsCodes.RESET);
    }
    private void printSpells(String color){
        System.out.println(color);
        System.out.println("SPELLS");
        System.out.println(Spell.header);
        int i = 0;
        for( Spell spell : marketSpell){
            System.out.println(spell + "" + i);
            i++;
        }
        System.out.println(ColorsCodes.RESET);
    }



}
