import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        // type your java code here
        BigInteger res = BigInteger.ONE;
        int i = n;
        while (i > 1) {
            res = res.multiply(BigInteger.valueOf(i));
            i -= 2;
        }
        return res;
    }
}
