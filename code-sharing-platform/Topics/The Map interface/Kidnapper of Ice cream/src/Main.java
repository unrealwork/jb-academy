import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.out;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> words = words(scanner.nextLine());
        Map<String, Long> note = words(scanner.nextLine());
        out.println(contains(words, note) ? "You get money" 
                : "You are busted");
    }

    private static boolean contains(final Map<String, Long> map, final Map<String, Long> mapToCheck) {
        return mapToCheck.entrySet().stream()
                .allMatch(wc -> {
                    if (map.containsKey(wc.getKey())) {
                        return map.get(wc.getKey()) >= wc.getValue();
                    }
                    return false;
                });
    }

    private static Map<String, Long> words(String nextLine) {
        return Arrays.stream(nextLine.split("\\s"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
