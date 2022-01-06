import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        // Write your code here
        Integer firstKey = map.firstKey();
        if (firstKey == null) {
            return map;
        }
        if (firstKey % 2 != 0) {
            return map.subMap(firstKey, true, firstKey + 4, true).descendingMap();
        }
        Integer lastKey = map.lastKey();
        return map.subMap(lastKey - 4, true, lastKey, true).descendingMap();
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
