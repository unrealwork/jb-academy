import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int n = scanner.nextInt();
        System.out.println(sumOfDigits(n));
    }

    private static int sumOfDigits(int n) {
        return Integer.toString(n).chars()
                .map(c -> c - '0').sum();
    }
}
