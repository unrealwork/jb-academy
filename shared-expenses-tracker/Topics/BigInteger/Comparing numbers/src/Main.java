import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    /**
     * It returns true if at least two of three given numbers are equal, otherwise - false.
     */
    public static boolean atLeastTwoAreEqual(BigInteger num1, BigInteger num2, BigInteger num3) {
        boolean a = Objects.equals(num1, num2);
        boolean b = Objects.equals(num2, num3);
        boolean c = Objects.equals(num1, num3);
        return a || b || c;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] parts = scanner.nextLine().split("\\s+");

        BigInteger num1 = null;
        BigInteger num2 = null;
        BigInteger num3 = null;

        try {
            num1 = new BigInteger(parts[0]);
            num2 = new BigInteger(parts[1]);
            num3 = new BigInteger(parts[2]);
        } catch (Exception e) {
            System.out.println("Can't parse a big integer value");
            e.printStackTrace();
        }

        System.out.println(atLeastTwoAreEqual(num1, num2, num3) ? "YES" : "NO");
    }
}
