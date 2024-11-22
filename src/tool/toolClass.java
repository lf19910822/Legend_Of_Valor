package tool;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class toolClass {
    public static Scanner scanner = new Scanner(System.in);

    public static int[][] directions8 = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1},  // right
            {-1, -1},// left up
            {-1, 1}, // right up
            {1, -1}, // left down
            {1, 1}   // right down
    };

    public static int[][] directions4 = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1},  // right
    };



    public static int getRandomNumber(int a, int b) {
        Random random = new Random();
        return random.nextInt(b - a + 1) + a;
    }

    public static void pauseFlow() {
        System.out.println("Press Enter to continue...");
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
        }
    }

    public static List<String[]> loadData(String path) {
        List<String[]> datas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            reader.readLine();  // skip the first line

            while((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+");
                datas.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    public static boolean Dice(double rate){
        if(rate <= 0){ return false;}
        if(rate >= 1){ return true;}

        int realRate = (int)(rate * 100);
        int random = getRandomNumber(0,100);

        return random < realRate;
    }

    public static boolean checkInput(String input, int min, int max){
        int intInput;

        try {
            intInput = Integer.parseInt(input);             // wrong type
        } catch (NumberFormatException e) {
            System.out.println("***Invalid input***");
            return false;
        }

        if( intInput < min || intInput > max ){             // wrong value
            System.out.println("***Invalid input***");
            return false;
        }
        return true;
    }

    public static int getAnIntInput( int min, int max){
        String Input = scanner.nextLine();
        if( !checkInput(Input, min, max ) ){  // input check 1
            return -1;
        } else{
            return Integer.parseInt(Input);
        }
    }

    public static <V> V getRandomValueFromList(List<V> list) {
        int randomIndex = new Random().nextInt(list.size());
        return list.get(randomIndex);
    }

    public static <V> V getRandomValueFromMap(Map<?, V> map) {
        List<V> values = new ArrayList<>(map.values());

        int randomIndex = new Random().nextInt(values.size());

        return values.get(randomIndex);
    }

    public static List<Integer> getIntegersInRange(int min, int max, int number ){
        int i;
        if( max - min + 1 < number ){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for( i = min; i <= max; i++ ){
            list.add(i);
        }

        List<Integer> result = new ArrayList<>();
        for( i = 0 ; i < number ; i++ ){
            int randomIndex = new Random().nextInt(list.size());
            result.add(list.get(randomIndex));
            list.remove(randomIndex);
        }
        return result;
    }





}
