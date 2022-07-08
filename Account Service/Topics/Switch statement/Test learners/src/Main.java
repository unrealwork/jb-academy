import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int n = scanner.nextInt();
        if (isUnknown(n)) {
            System.out.println("Unknown number");
        } else {
            System.out.println(isCorrect(n) ? "Yes!" : "No!");
        }
    }

    private static boolean isUnknown(int n) {
        return n < 1 || n > 4;
    }

    private static boolean isCorrect(int n) {
        return n == 1;
    }
}
