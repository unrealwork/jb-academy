import java.util.Scanner;

final class Main {
    private Main() {

    }

    @SuppressWarnings("PMD.SystemPrintln")
    public static void main(final String[] args) {
        // put your code here
        int[][] cinema;
        try (Scanner scanner = new Scanner(System.in)) {
            final int rows = scanner.nextInt();
            final int columns = scanner.nextInt();
            cinema = readMatrix(scanner, rows, columns);
            final int reqSeats = scanner.nextInt();
            System.out.println(solve(cinema, reqSeats));
        }
    }

    private static int solve(final int[][] cinema, final int reqSeats) {
        for (int i = 0; i < cinema.length; i++) {
            final int[] row = cinema[i];
            if (hasConsecutivePlaces(row, reqSeats)) {
                return i + 1;
            }
        }
        return 0;
    }

    private static boolean hasConsecutivePlaces(final int[] row, final int reqSeats) {
        int currentFree = 0;
        for (final int seat : row) {
            if (seat == 0) {
                currentFree++;
            } else {
                if (currentFree >= reqSeats) {
                    return true;
                }
                currentFree = 0;
            }
        }
        return currentFree >= reqSeats;
    }

    private static int[][] readMatrix(final Scanner scanner, final int rows, final int columns) {
        int[][] res = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res[i][j] = scanner.nextInt();
            }
        }
        return res;
    }

}
