import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        Pattern p = Pattern.compile("(^|.*[^\\w])(?<word>[a-zA-Z]{" + size + "})([^\\w].*|$)");
        Matcher m = p.matcher(line);
        // write your code here
        boolean isMatched = m.matches();
        System.out.println(isMatched ? "YES" : "NO");
    }
}
