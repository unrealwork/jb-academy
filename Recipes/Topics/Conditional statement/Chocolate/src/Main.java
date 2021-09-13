import java.io.BufferedInputStream;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int rest = n * m - k;
            boolean res = rest > 0 && (rest % n == 0 || rest % m == 0);
            System.out.println(res ? "YES" : "NO");
        }
    }
}
