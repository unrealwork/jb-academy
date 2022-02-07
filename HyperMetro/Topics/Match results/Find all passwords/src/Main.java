import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern p = Pattern.compile("password[:\\s]+(\\w+)", Pattern.CASE_INSENSITIVE);
        // write your code here
        Matcher m = p.matcher(text);
        boolean isFound = false;
        while (m.find()) {
            isFound = true;
            System.out.println(m.group(1));
        }
        if (!isFound) {
            System.out.println("No passwords found.");
        }
    }
}
