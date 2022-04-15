package processor;

public class DoubleMatrix<T extends Number> implements Matrix<Double> {
    private final AbstractMatrix<Double> delegate;

    public DoubleMatrix(int rows, int columns, Double[][] data) {
        delegate = new AbstractMatrix<>(rows, columns, data, TypeOperations.doubles());
    }

    @Override
    public int getRows() {
        return delegate.getRows();
    }

    @Override
    public int getColumns() {
        return delegate.getColumns();
    }

    @Override
    public Double[][] data() {
        return delegate.data();
    }

    @Override
    public String content() {
        return delegate.content();
    }

    @Override
    public Double[] column(int index) {
        return delegate.column(index);
    }

    @Override
    public Matrix<Double> scalarMultiply(Double k) {
        return delegate.scalarMultiply(k);
    }

    @Override
    public Matrix<Double> plus(Matrix<Double> m) {
        return delegate.plus(m);
    }

    @Override
    public Matrix<Double> times(Matrix<Double> b) {
        return delegate.times(b);
    }

    @Override
    public Matrix<Double> transpose(TranspositionType type) {
        return delegate.transpose(type);
    }
}
