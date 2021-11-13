import java.util.*;
import java.util.regex.Pattern;

@SuppressWarnings("squid:S106")
class Date {
    @SuppressWarnings("squid:S5843")
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();
        Pattern p = Pattern.compile("^((19|20)\\d\\d[-/.](1[012]|0\\d)[-/.]([012]\\d|3[01])|([012]\\d|3[01])[-/.](1[012]|0\\d)[-/.](19|20)\\d\\d)$");
        System.out.println(p.matcher(date).matches() ? "Yes" : "No");
    }
}
