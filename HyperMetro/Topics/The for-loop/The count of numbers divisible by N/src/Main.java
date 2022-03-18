import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final int a = scanner.nextInt();
            final int b = scanner.nextInt();
            final int n = scanner.nextInt();
            final long res = a % n == 0 ? (b / n - a / n) + 1 : b / n - a / n;
            System.out.println(res);
        }
        // start coding here
    }
}
