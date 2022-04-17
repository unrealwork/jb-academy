import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            dec(n, n, "");
        }
    }

    public static void dec(int n, int max, String str) {
        if (n == 0) {
            System.out.println(str);
        } else {
            if (max > 1) {
                dec(n, max - 1, str);
            }
            if (max <= n) {
                dec(n - max, max, str + " " + max);
            }
        }
    }
}
