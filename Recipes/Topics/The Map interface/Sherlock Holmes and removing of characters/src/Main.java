import java.io.BufferedInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            final Map<Character, Long> word1Counters = counting(scanner.nextLine());
            final Map<Character, Long> word2Counters = counting(scanner.nextLine());
            System.out.println(diff(word1Counters, word2Counters));
        }
    }

    private static long diff(Map<Character, Long> word1Counters, Map<Character, Long> word2Counters) {
        long res = 0;
        for (Map.Entry<Character, Long> kv : word1Counters.entrySet()) {
            if (word2Counters.containsKey(kv.getKey())) {
                res += Math.abs(kv.getValue() - word2Counters.get(kv.getKey()));
            } else {
                res += kv.getValue();
            }
        }
        for (Map.Entry<Character, Long> kv : word2Counters.entrySet()) {
            if (!word1Counters.containsKey(kv.getKey())) {
                res += kv.getValue();
            }
        }

        return res;
    }

    private static Map<Character, Long> counting(String s) {
        return s.toLowerCase().chars()
                .mapToObj(code -> (char) code)
                .collect(groupingBy(Function.identity(), Collectors.counting()));
    }
}
