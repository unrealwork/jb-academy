import java.io.BufferedInputStream;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            System.out.println(isLucky(sc.next()) ? "Lucky" : "Regular");
        }
    }

    private static boolean isLucky(String next) {
        return numSum(next.substring(0, 3)) == numSum(next.substring(3));
    }

    private static int numSum(String numString) {
        return numString.chars().map(c -> c - '0')
                .sum();
    }
}
