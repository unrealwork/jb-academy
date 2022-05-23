import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            BigDecimal a = new BigDecimal(sc.nextLine());
            BigDecimal b = new BigDecimal(sc.nextLine());
            System.out.println(a.multiply(b));
        }
    }
}
