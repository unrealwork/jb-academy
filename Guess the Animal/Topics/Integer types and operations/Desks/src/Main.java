import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        long res = IntStream.range(0, 3)
                .map(i -> desksForGroup(scanner.nextInt()))
                .sum();
        System.out.println(res);
    }

    private static int desksForGroup(final int numberOfStudents) {
        return numberOfStudents % 2 == 0 ? numberOfStudents / 2 : numberOfStudents/2 + 1;
    }
}
