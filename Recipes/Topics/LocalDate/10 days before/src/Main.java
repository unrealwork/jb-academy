import java.io.BufferedInputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            final LocalDate date = LocalDate.parse(scanner.next());
            System.out.println(date.minus(10, ChronoUnit.DAYS));
        }
    }
}
