import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        final Scanner scanner = new Scanner(System.in);
        final LocalDate date = LocalDate.ofYearDay(scanner.nextInt(), scanner.nextInt());
        System.out.println(date.getDayOfMonth() == 1);
    }
}