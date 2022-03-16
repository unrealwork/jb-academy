import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            Deque<Integer> deque = new ArrayDeque<>(n);
            for (int i = 0; i < n; i++) {
                deque.add(sc.nextInt());
            }
            while (!deque.isEmpty()) {
                System.out.println(deque.removeLast());
            }
        }
    }
}
