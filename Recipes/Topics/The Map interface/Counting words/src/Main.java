import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        // write your code here
        final TreeMap<String, Integer> map = new TreeMap<>();
        for (String string : strings) {
            map.putIfAbsent(string, 0);
            map.computeIfPresent(string, (k, v) -> v + 1);
        }
        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        // write your code here
        map.forEach((k, v) -> System.out.printf("%s : %d%n", k, v));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}