import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        var s = scanner.nextLine();
        int l = s.length();
        var middle = l /2;
        System.out.println(s.substring(0, l %2 == 0 ? middle - 1: middle ) + s.substring(middle+1));
    }
}
