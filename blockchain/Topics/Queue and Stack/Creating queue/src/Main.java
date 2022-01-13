import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        // write your code here
        final Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(2, 0, 1, 7));
        System.out.println(queue);
    }
}
