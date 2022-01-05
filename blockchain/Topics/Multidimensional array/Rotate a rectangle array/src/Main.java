import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        final int rows = scanner.nextInt();
        final int columns = scanner.nextInt();
        int[][] data = readMatrix(scanner, rows, columns);
        printMatrix(rotate(data, rows, columns));
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

    private static int[][] rotate(final int[][] data, int rows, int columns) {
        int[][] res = new int[columns][rows];
        for (int i = 0; i < columns; i++) {
            for (int j = rows - 1; j >= 0; j--) {
                res[i][rows - j - 1] = data[j][i];
            }
        }
        return res;
    }

    private static void printMatrix(final int[][] m) {
        for (int[] arr : m) {
            for (int n : arr) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
