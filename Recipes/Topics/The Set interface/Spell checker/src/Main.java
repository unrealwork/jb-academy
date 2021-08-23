import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            int dictSize = sc.nextInt();
            sc.nextLine();
            Set<String> knownWords = IntStream.range(0, dictSize)
                    .mapToObj(n -> sc.nextLine())
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet());
            int lineCount = sc.nextInt();
            sc.nextLine();
            IntStream.range(0, lineCount)
                    .mapToObj(n -> sc.nextLine())
                    .flatMap(Main::lineToWords)
                    .filter(Predicate.not(word -> knownWords.contains(word.toLowerCase())))
                    .distinct()
                    .forEach(System.out::println);
        }
    }

    private static Stream<String> lineToWords(final String line) {
        return Arrays.stream(line.split(" "));
    }
}