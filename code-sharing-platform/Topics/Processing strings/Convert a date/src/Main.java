import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        var s = scanner.nextLine();
        try {
            String[] comps = s.split("-");
            var d = Integer.parseInt(comps[2]);
            var m = Integer.parseInt(comps[1]);
            var y = Integer.parseInt(comps[0]);
            if (d > 0 && d<= 31 && y > 0 && m > 0 && m <= 12) {
                System.out.printf("%02d/%02d/%04d", m, d,y);
            } else {
                System.out.println("Incorrect input");
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
    }
}
