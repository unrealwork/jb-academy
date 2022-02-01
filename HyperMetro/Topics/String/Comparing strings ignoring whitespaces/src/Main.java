import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String s = scanner.nextLine().replaceAll(" ", "");
        String t = scanner.nextLine().replaceAll(" ", "");
        System.out.println(s.equals(t));
    }
}
