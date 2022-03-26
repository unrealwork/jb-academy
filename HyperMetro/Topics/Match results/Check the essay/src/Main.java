import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class FindTheKeys {
    
    public static final Pattern KEY_PATTERN = Pattern.compile("the\\s+key\\s+is\\s+([\\d[b-df-hj-np-tv-z]]+|[!?#aeoui]+)\\s", Pattern.CASE_INSENSITIVE);
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        Matcher matcher = KEY_PATTERN.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
        
    }
}
