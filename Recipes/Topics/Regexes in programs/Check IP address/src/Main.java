import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        final Scanner scanner = new Scanner(System.in);
        final String s = scanner.nextLine();
        final boolean isCorrect = s.matches("(([0-1]?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}([0-1]?\\d?\\d|2[0-4]\\d|25[0-5])");
        System.out.println(isCorrect ? "YES" : "NO");
    }
}