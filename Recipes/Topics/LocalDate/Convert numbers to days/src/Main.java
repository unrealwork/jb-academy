import java.io.BufferedInputStream;
import java.util.Scanner;

import static java.time.LocalDate.ofYearDay;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            int year = sc.nextInt();
            System.out.println(ofYearDay(year, sc.nextInt()));
            System.out.println(ofYearDay(year, sc.nextInt()));
            System.out.println(ofYearDay(year, sc.nextInt()));
        }
    }
}
