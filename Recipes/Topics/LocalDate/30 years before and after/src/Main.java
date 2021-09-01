import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            final LocalDate date = LocalDate.parse(sc.next());
            System.out.println(date.minus(30, ChronoUnit.YEARS));
            System.out.println(date.plus(30, ChronoUnit.YEARS));
        }
    }
}
