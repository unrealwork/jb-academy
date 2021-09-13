import java.io.BufferedInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            int minKey = sc.nextInt();
            int maxKey = sc.nextInt();
            int keysCount = sc.nextInt();
            final Map<Integer, String> map = new TreeMap<>();
            for (int i = 0; i < keysCount; i++) {
                int key = sc.nextInt();
                String value = sc.next();
                if (key >= minKey && key <= maxKey) {
                    map.put(key, value);
                }
            }
            map.forEach((k, v) -> System.out.printf("%d %s%n", k, v));
        }
    }
}
