import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int n = scanner.nextInt();
        int nextEven = n % 2 == 0 ? n + 2 : n + 1;
        System.out.println(nextEven);
    }
}
