import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            double discr = Math.sqrt(b * b - 4 * a * c);
            double x1 = (-b + discr) / (2 * a);
            double x2 = (-b - discr) / (2 * a);
            System.out.println(x1 < x2 ? x1 + " " + x2 : x2 + " " + x1);
        }
    }
}
