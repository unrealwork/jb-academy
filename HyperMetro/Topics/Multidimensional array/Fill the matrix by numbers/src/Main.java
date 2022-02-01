import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            final int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ", Math.abs(i-j));
                }
                System.out.println();
            }
        }
    }
}
