import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        final int rows = scanner.nextInt();
        final int columns = scanner.nextInt();
        int[][] cinema = readMatrix(scanner, rows, columns);
        final int reqSeats = scanner.nextInt();
        System.out.println(solve(cinema, reqSeats));
    }

    private static int solve(int[][] cinema, final int reqSeats) {
        for (int i = 0; i < cinema.length; i++) {
            int[] row = cinema[i];
            if (hasConsecutivePlaces(row, reqSeats)) {
                return i + 1;
            }
        }
        return 0;
    }

    private static boolean hasConsecutivePlaces(int[] row, int reqSeats) {
        int currentFree = 0;
        for (int seat : row) {
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

    private static int[][] readMatrix(Scanner scanner, int rows, int columns) {
        int[][] res = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res[i][j] = scanner.nextInt();
            }
        }
        return res;
    }

}
