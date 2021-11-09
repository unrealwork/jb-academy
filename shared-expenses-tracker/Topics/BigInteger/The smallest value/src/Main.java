import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        BigInteger n = new BigInteger(scanner.next());
        System.out.println(smallestFact(n));
    }

    private static long smallestFact(BigInteger n) {
        BigInteger res = BigInteger.ONE;
        long i = 0;
        do {
            i++;
            res = res.multiply(BigInteger.valueOf(i));
        } while (res.compareTo(n) < 0);
        return i;
    }
}
