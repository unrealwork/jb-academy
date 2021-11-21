import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double x = scanner.nextDouble();
        double sum = 1.0;
        double it = 1.0;
        for (int i = 0; i < 3; i++) {
            it*=x;
            sum += it;
        }
        System.out.println(sum);
    }
}
