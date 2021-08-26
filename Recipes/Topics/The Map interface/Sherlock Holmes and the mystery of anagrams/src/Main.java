import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            final Map<Character, Long> map1 = wordToMap(scanner.nextLine());
            final Map<Character, Long> map2 = wordToMap(scanner.nextLine());
            System.out.println(map1.equals(map2) ? "yes" : "no");
        }
    }

    private static Map<Character, Long> wordToMap(final String word) {
        return word.toLowerCase().chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}