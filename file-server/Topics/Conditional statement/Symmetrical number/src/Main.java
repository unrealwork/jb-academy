import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(isSymmetrical(num) ? 1 : 0);
    }

    static boolean isSymmetrical(int num) {
        int left = num / 100;
        int right = num % 10 * 10 + num / 10 % 10;
        return left == right;
    }
}
