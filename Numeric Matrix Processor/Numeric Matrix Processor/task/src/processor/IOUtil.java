package processor;


import java.util.Scanner;

public class IOUtil {
    private IOUtil() {
    }

    public static Matrix<Double> readDoubleMatrix(Scanner scanner, int rows, int columns) {
        final Double[][] data = new Double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = scanner.nextDouble();
            }
        }
        return new DoubleMatrix<>(rows, columns, data);
    }
}
