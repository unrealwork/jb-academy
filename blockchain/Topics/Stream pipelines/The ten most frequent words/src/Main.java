import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.lines()
                    .map(line -> line.split("[^a-zA-Z0-9]+"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                    .map(Map.Entry::getKey)
                    .limit(10)
                    .forEach(System.out::println);

        }
    }
}
