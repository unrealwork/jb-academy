import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(isValidTriangle(a,b,c)?"YES":"NO");
    }

    private static boolean isValidTriangle(int a, int b, int c) {
        return (a + b > c) && (a+ c > b) && (b + c > a);
    }
}
