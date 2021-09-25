import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int height = scanner.nextInt();
        int dailyShift = scanner.nextInt();
        int nightShift = scanner.nextInt();
        int dailySpeed = (dailyShift - nightShift);
        int res = 0;
        if (dailyShift >= height) {
            res = 1;
        } else {
            int heightWithoutLastDay = height - dailyShift;
            res = (heightWithoutLastDay % dailySpeed == 0 ? heightWithoutLastDay / dailySpeed :
                    (heightWithoutLastDay / dailySpeed + 1)) + 1;
        }
        System.out.println(res);
    }
}
