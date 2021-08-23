import java.io.BufferedInputStream;
import java.util.Scanner;

class Main {

    public static final int BARRIER = 1000;

    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            int n = 0;
            int sum = 0;
            do {
                n = sc.nextInt();
                sum += n;
                if (sum >= BARRIER) {
                    sum = sum - 1000;
                    break;
                }
            } while (n != 0);
            System.out.println(sum);
        }
    }
}