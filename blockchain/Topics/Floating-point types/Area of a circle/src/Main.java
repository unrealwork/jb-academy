import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double r = scanner.nextDouble();
            System.out.println(Math.PI * r * r);
        }
        // put your code here

    }
}
