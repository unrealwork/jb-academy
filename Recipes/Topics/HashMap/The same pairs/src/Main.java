import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        // write your code here
        int count = 0;
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String k1 = entry.getKey();
            String v1 = entry.getValue();
            if (map2.containsKey(k1) && map2.get(k1).equals(v1)) {
                count++;
            }
        }
        System.out.println(count);
    }
}