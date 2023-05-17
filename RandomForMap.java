import java.util.Random;
import java.util.TreeMap;

public class RandomForMap {
    TreeMap<Integer, Integer> numbers = new TreeMap<>();
    int count = 0;
    Random rnd = new Random();

    TreeMap<Integer, Integer> addRandomNum() {
        // numbers.put(0, 4);
        // numbers.put(1, 10);
        // numbers.put(2, 3);
        // numbers.put(3, 5);
        // numbers.put(4, 1);
        while (count != 8) {

        numbers.put(count, rnd.nextInt(50));
        count++;
        }

        return numbers;
    }
}
