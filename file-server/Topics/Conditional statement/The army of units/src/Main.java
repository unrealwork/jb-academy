import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            int unitsAmount = scanner.nextInt();
            System.out.println(armyCategory(unitsAmount));
        }
    }

    private static String armyCategory(final int n) {
        if (n < 1) {
            return "no army";
        }
        if (n < 20) {
            return "pack";
        }
        if (n < 250) {
            return "throng";
        }
        if (n < 1000) {
            return "zounds";
        } else {
            return "legion";
        }
    }
}
