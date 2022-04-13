package processor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

class AbstractMatrix<T extends Number> implements Matrix<T> {
    private final int rows;
    private final int columns;
    private final T[][] data;
    private final TypeOperations<T> operations;

    AbstractMatrix(int rows, int columns, TypeOperations<T> operations) {
        this.rows = rows;
        this.columns = columns;
        this.data = (T[][]) Array.newInstance(operations.typeClass(), rows, columns);
        this.operations = operations;
    }

    AbstractMatrix(int rows, int columns, T[][] data, TypeOperations<T> operations) {
        this.rows = rows;
        this.columns = columns;
        this.data = data;
        this.operations = operations;
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
    public T[][] data() {
        return data;
    }

    @Override
    public String content() {
        return Arrays.stream(data)
                .map(row -> joinToString(" ", row))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public T[] column(int index) {
        T[] res = (T[]) Array.newInstance(operations.typeClass(), rows);
        for (int i = 0; i < rows; i++) {
            res[i] = data[i][index];
        }
        return res;
    }

    @Override
    public Matrix<T> scalarMultiply(T k) {
        AbstractMatrix<T> res = new AbstractMatrix<T>(rows, columns, operations);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res.data[i][j] = operations.multiply(data[i][j], k);
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
    public Matrix<T> plus(Matrix<T> matrix) {
        if (rows != matrix.getRows() || columns != matrix.getColumns()) {
            throw new NotMatchingDimensionsException();
        }
        AbstractMatrix<T> res = new AbstractMatrix<>(rows, columns, operations);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res.data[i][j] = operations.add(data[i][j], matrix.data()[i][j]);
            }
        }
        return res;
    }

    @Override
    public Matrix<T> times(Matrix<T> matrix) {
        if (columns != matrix.getRows()) {
            throw new NotMatchingDimensionsException();
        }
        AbstractMatrix<T> res = new AbstractMatrix<>(rows, matrix.getColumns(), operations);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                res.data[i][j] = dotProduct(row(i), matrix.column(j));
            }
        }
        return res;
    }

    private T dotProduct(T[] row, T[] column) {
        T res = operations.zero();
        for (int i = 0; i < row.length; i++) {
            final T c = operations.multiply(row[i], column[i]);
            res = operations.add(res, c);
        }
        return res;
    }
}
