import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamUtils {
    
    public static Stream<Integer> generateStreamWithPowersOfTwo(int n) {
        return Stream.iterate(1, e -> e*2)
                .limit(n);// replace it with your code
    }
}
