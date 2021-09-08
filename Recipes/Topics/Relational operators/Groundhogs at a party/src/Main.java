import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int peanuts = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();
        boolean res = !isWeekend && (peanuts >= 10 && peanuts <= 20) || isWeekend && (peanuts >= 15 && peanuts <= 25);
        System.out.println(res);
    }
}
