import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        final int firstTime = readTime(scanner);
        final int secondTime = readTime(scanner);
        System.out.println(secondTime - firstTime);
    }

    private static int readTime(Scanner sc) {
        return sc.nextInt() * 3600 + sc.nextInt() * 60 + sc.nextInt();
    }
}
