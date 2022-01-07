import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        final int n = scanner.nextInt();
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final Random random = new Random(a + b);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            final int randomInRange = random.nextInt(b - a + 1) + a;
            sum += randomInRange;
        }
        System.out.println(sum);
    }
}
