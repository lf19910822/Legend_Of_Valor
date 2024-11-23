package Items;
import tool.formats;

//The parent class of all items. All items have name, price, level and type.
public class Items {
    protected String name;
    protected int price;
    protected int level;
    protected String Type;

    public static String sellingHeader = String.format(formats.sellingFormatsHeader, "Name", "Type", "Price");

    Items(String name, int price, int level, String Type ) {      // The class of items
        this.name = name;
        this.price = price;
        this.level = level;
        this.Type = Type;
    }

    public void printSellingInformation(int index){
        System.out.println(String.format(formats.sellingFormatsData, this.name, this.Type, this.price) + "\t" + index);
    }


    public String getType() {
        return this.Type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
