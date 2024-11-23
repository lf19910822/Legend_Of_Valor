package tool;


//The interface contains many string formats. We use them when we need to print some information with format.
public interface formats {

    String ArmoryFormatsDatas = "| %-20s | %-10d | %-10d | %-20d |";
    String ArmoryFormatsHeader = "| %-20s | %-10s | %-10s | %-20s |";

    String PotionFormatsDatas = "| %-20s | %-5d | %-5d | %-20d | %-50s |";
    String PotionFormatsHeader = "| %-20s | %-5s | %-5s | %-20s | %-50s |";

    String SpellFormatsDatas = "| %-10s | %-16s | %-5d | %-5d | %-8d | %-8d |";
    String SpellFormatsHeader = "| %-10s | %-16s | %-5s | %-5s | %-8s | %-8s |";

    String WeaponFormatsDatas = "| %-20s | %-5d | %-5d | %-6d | %-13d |";
    String WeaponFormatsHeader = "| %-20s | %-5s | %-5s | %-6s | %-13s |";

    String sellingFormatsHeader = "| %-20s | %-10s | %-5s |";
    String sellingFormatsData = "| %-20s | %-10s | %-5d |";
}
