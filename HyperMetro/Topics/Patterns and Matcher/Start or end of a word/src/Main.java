import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile(".*(\\b" + part + "|" + part + "\\b).*", Pattern.CASE_INSENSITIVE);
        // write your code here
        boolean isMatched = pattern.matcher(line).matches();
        System.out.println(isMatched ? "YES" : "NO");
    }
}
