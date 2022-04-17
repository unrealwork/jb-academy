package processor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
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

    private AbstractMatrix<T> copyRotate() {
        return new AbstractMatrix<>(columns, rows, operations);
    }

    private AbstractMatrix<T> transposeMainDiag() {
        AbstractMatrix<T> res = copyRotate();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                int offset = i - j;
                res.data[i][j] = data[i - offset][i];
                res.data[i - offset][i] = data[i][j];
            }
        }
        return res;
    }

    private AbstractMatrix<T> transposeSideDiag() {
        AbstractMatrix<T> res = copyRotate();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - i; j++) {
                int offset = columns - i - j - 1;
                res.data[i][j] = data[i + offset][columns - i - 1];
                res.data[i + offset][columns - i - 1] = data[i][j];
            }
        }
        return res;
    }

    private AbstractMatrix<T> transposeVerticalLine() {
        AbstractMatrix<T> res = copy();
        boolean hasEvenColumns = columns % 2 == 0;
        int middle = columns / 2;
        int columnsLimit = hasEvenColumns ? middle : middle + 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columnsLimit; j++) {
                int offset = hasEvenColumns ? middle - j - 1 : middle - j;
                int mirrorJ = middle + offset;
                res.data[i][j] = data[i][mirrorJ];
                res.data[i][mirrorJ] = data[i][j];
            }
        }
        return res;
    }

    private AbstractMatrix<T> transposeHorizontalLine() {
        AbstractMatrix<T> res = copy();
        boolean hasEvenRows = rows % 2 == 0;
        int middle = rows / 2;
        int rowsLimit = hasEvenRows ? middle : middle + 1;
        for (int i = 0; i < rowsLimit; i++) {
            for (int j = 0; j < columns; j++) {
                int offset = hasEvenRows ? middle - i - 1 : middle - i;
                int mirrorI = middle + offset;
                res.data[i][j] = data[mirrorI][j];
                res.data[mirrorI][j] = data[i][j];
            }
        }
        return res;
    }

    @Override
    public Matrix<T> transpose(TranspositionType type) {
        switch (type) {
            case MAIN_DIAG:
                return transposeMainDiag();
            case SIDE_DIAG:
                return transposeSideDiag();
            case VERTICAL_LINE:
                return transposeVerticalLine();
            default:
                return transposeHorizontalLine();
        }
    }

    private AbstractMatrix<T> minor(int minorI, int minorJ) {
        final AbstractMatrix<T> res = new AbstractMatrix<>(rows - 1, columns - 1, operations);
        for (int i = 0; i < rows; i++) {
            if (i == minorI) {
                continue;
            }
            for (int j = 0; j < columns; j++) {
                if (j == minorJ) {
                    continue;
                }
                int resI = (i > minorI) ? i - 1 : i;
                int resJ = (j > minorJ) ? j - 1 : j;
                res.data[resI][resJ] = data[i][j];
            }
        }
        return res;
    }

    private T cofactor(int i, int j) {
        final T sign = ((i + j) % 2 == 0) ? operations.one() : operations.negateOne();
        AbstractMatrix<T> minor = minor(i, j);
        return operations.multiply(sign, minor.det());
    }

    @Override
    public T det() {
        if (rows != columns) {
            throw new NotMatchingDimensionsException("Determinant can be calculated only for square matrix");
        }
        if (rows == 2) {
            T a = operations.multiply(data[0][0], data[1][1]);
            T b = operations.multiply(data[0][1], data[1][0]);
            return operations.minus(a, b);
        }
        T res = operations.zero();
        for (int i = 0; i < columns; i++) {
            T el = operations.multiply(data[0][i], cofactor(0, i));
            res = operations.add(res, el);
        }
        return res;
    }

    private AbstractMatrix<T> cofactorMatrix() {
        final AbstractMatrix<T> res = new AbstractMatrix<>(rows, columns, operations);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res.data[i][j] = cofactor(i, j);
            }
        }
        return res;
    }

    @Override
    public Matrix<T> inverse() {
        if (rows != columns) {
            throw new NotMatchingDimensionsException("Inverse matrix can be calculated only for square matrix");
        }
        T det = det();
        AbstractMatrix<T> cofactor = cofactorMatrix();
        return cofactor
                .transpose(TranspositionType.MAIN_DIAG)
                .scalarMultiply(operations.inverseMult(det));
    }

    private AbstractMatrix<T> copy() {
        return new AbstractMatrix<>(rows, columns, operations);
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
