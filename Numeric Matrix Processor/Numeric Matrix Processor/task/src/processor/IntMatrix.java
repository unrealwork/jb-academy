package processor;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IntMatrix implements Matrix<Integer> {
    private final int rows;
    private final int columns;
    private final Integer[][] data;


    private IntMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new Integer[rows][columns];
    }

    private IntMatrix(int rows, int columns, Integer[][] data) {
        this.rows = rows;
        this.columns = columns;
        this.data = data;
    }

    public static IntMatrix withDimension(int rows, int columns) {
        return new IntMatrix(rows, columns);
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public Integer[][] data() {
        return data;
    }

    @Override
    public String content() {
        return Arrays.stream(data)
                .map(row -> joinToString(" ", row))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Matrix<Integer> scalarMultiply(Integer k) {
        IntMatrix res = IntMatrix.withDimension(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res.data[i][j] = data[i][j] * k;
            }
        }
        return res;
    }

    private static <T> String joinToString(String delimiter, T... arr) {
        return Arrays.stream(arr)
                .map(Objects::toString)
                .collect(Collectors.joining(delimiter));
    }

    @Override
    public Matrix<Integer> plus(Matrix<Integer> matrix) {
        if (rows != matrix.getRows() || columns != matrix.getColumns()) {
            throw new NotMatchingDimensionsException();
        }
        IntMatrix res = withDimension(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res.data[i][j] = data[i][j] + matrix.data()[i][j];
            }
        }
        return res;
    }

    public static IntMatrix read(final Scanner scanner) {
        final int rows = scanner.nextInt();
        final int columns = scanner.nextInt();
        Integer[][] data = new Integer[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        return new IntMatrix(rows, columns, data);
    }
}
