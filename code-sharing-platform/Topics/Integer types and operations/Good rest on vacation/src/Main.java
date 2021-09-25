import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        final int durationDays = scanner.nextInt();
        final int dailyFoodCost = scanner.nextInt();
        final int flightCost = scanner.nextInt();
        final int nightStandingCost = scanner.nextInt();
        final long res = durationDays * (long)dailyFoodCost + (durationDays - 1L) * nightStandingCost + 2L * flightCost;
        System.out.println(res);
    }
}
