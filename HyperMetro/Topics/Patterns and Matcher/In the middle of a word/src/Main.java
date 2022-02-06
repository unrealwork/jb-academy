import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        // write your code here
        Pattern p = Pattern.compile(".*[a-zA-Z]" + part.toLowerCase().trim() + "[a-zA-Z].*", Pattern.CASE_INSENSITIVE);
        boolean isMatched = p.matcher(line).matches();
        System.out.println(isMatched ? "YES" : "NO");
    }
}
