import java.util.ArrayList;
import java.util.List;

class Utils {

    public static List<Integer> sortOddEven(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>(numbers);
        list.sort(Utils::compare);
        return list;
    }

    private static int compare(Integer a, Integer b) {

        boolean firstEven = a % 2 == 0;
        boolean secondEven = b % 2 == 0;
        if (firstEven && secondEven) {
            return -Integer.compare(a, b);
        } else {
            if (!firstEven && !secondEven) {
                return Integer.compare(a, b);
            }
        }
        return firstEven ? 1 : -1;
    }
}
