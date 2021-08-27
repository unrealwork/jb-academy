// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    // define getFirst method here
    public static <T> T getFirst(final T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[0];
    }
}