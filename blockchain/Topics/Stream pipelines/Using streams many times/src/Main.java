import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FunctionUtils {

    public static <T> Supplier<Stream<T>> saveStream(Stream<T> stream) {
        // write your code here
        List<T> elements = stream.collect(Collectors.toList());
        return elements::stream;
    }
}
