import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            BigDecimal capital = new BigDecimal(sc.nextLine());
            int perc = sc.nextInt();
            int years = sc.nextInt();
            BigDecimal mult = BigDecimal.ONE.add(BigDecimal.valueOf(perc / 100d)).pow(years);
            BigDecimal res = capital
                    .multiply(mult).setScale(2, RoundingMode.CEILING);
            System.out.println("Amount of money in the account: " + res);
        }
    }
}
