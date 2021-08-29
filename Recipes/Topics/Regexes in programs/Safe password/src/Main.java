import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        final Scanner scanner = new Scanner(System.in);
        final String password = scanner.nextLine();
        final boolean isCorrect = password.matches(".{12,}") && password.matches(".*\\d.*")
                && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*");
        System.out.println(isCorrect ? "YES" : "NO");
    }
}