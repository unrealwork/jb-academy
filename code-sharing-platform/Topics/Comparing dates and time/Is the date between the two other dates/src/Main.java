import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            LocalDate x = LocalDate.parse(sc.next());
            LocalDate m = LocalDate.parse(sc.next());
            LocalDate n = LocalDate.parse(sc.next());
            System.out.println(x.isAfter(m) && x.isBefore(n) || x.isBefore(m) && x.isAfter(n));
        }
    }
}
