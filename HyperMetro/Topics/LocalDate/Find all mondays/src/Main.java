import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            LocalDate startMonthDate = LocalDate.of(year, month, 1);
            while (startMonthDate.getDayOfWeek() != DayOfWeek.MONDAY) {
                startMonthDate = startMonthDate.plusDays(1);
            }
            LocalDate mondayMonthIt = startMonthDate;
            while (mondayMonthIt.getMonthValue() == month) {
                System.out.println(mondayMonthIt);
                mondayMonthIt = mondayMonthIt.plusWeeks(1);
            }
        }
    }
}
