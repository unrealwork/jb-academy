import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            double dot = a * c + b * d;
            double cosV = dot / (magn(a, b) * magn(c, d));
            double angrad = Math.acos(cosV);
            double degree = Math.toDegrees(angrad);
            System.out.println(degree);
        }
    }

    private static double magn(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }
}
