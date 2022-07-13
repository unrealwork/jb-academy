import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        long sum = 0L;
        int n = scanner.nextInt();
        while (n != 0) {
            sum += n;
            n = scanner.nextInt();
        }
        System.out.println(sum);
    }
}
