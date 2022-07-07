import java.util.Scanner;

enum Seasons {SPRING, SUMMER, AUTUMN, WINTER}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Seasons season = Seasons.valueOf(scanner.nextLine());

        // write your code here
        int temperature = switch (season) {
            case AUTUMN, SPRING -> 20;
            case SUMMER -> 37;
            case WINTER -> 1;
        };

        System.out.println(temperature);
    }
}
