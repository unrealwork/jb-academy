import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            BigDecimal a = new BigDecimal(sc.nextLine());
            BigDecimal b = new BigDecimal(sc.nextLine());
            BigDecimal c = new BigDecimal(sc.nextLine());
            BigDecimal res = a.add(b).add(c).divide(BigDecimal.valueOf(3),RoundingMode.HALF_UP)
                    .setScale(0, RoundingMode.HALF_UP);
            System.out.println(res);
        }
    }
}
