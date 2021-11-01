import java.util.Scanner;

@SuppressWarnings("squid:S106")
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        int res = scanner.nextInt();
        System.out.println(analyzeSleep(min, max, res));

    }

    private static String analyzeSleep(final int min, final int max, final int res) {
        if (res >= min && res <= max) {
            return "Normal";
        } else {
            if (res > max) {
                return "Excess";
            } else {
                return "Deficiency";
            }
        }
    }
}
