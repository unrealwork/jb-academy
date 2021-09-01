import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        final Scanner scanner = new Scanner(System.in);
        final LocalDate ld = LocalDate.parse(scanner.next());
        System.out.println(ld.getDayOfYear() + " " + ld.getDayOfMonth());
    }
}
