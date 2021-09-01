import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime dateTime = LocalDateTime.parse(scanner.next());
        System.out.println(dateTime.plus(11, ChronoUnit.HOURS).toLocalDate());
    }
}