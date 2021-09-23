// do not remove imports

import java.util.Arrays;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

class ArrayUtils {
    // define info method here
    public static <T> String info(T[] array) {
        return Arrays.stream(array).map(Objects::toString)
                .collect(joining(", ", "[", "]"));
    }
}
