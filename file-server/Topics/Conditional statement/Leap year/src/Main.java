import java.io.BufferedInputStream;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            final int year = sc.nextInt();
            System.out.println(isLeap(year)? "Leap" : "Regular");
        }
    }

    private static boolean isLeap(final int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }
}
