package processor;

public interface Matrix<T extends Number> {
    int getRows();

    int getColumns();

    T[][] data();

    String content();

    default Number[] get(int index) {
        return data()[index];
    }

    Matrix<T> scalarMultiply(T k);
    
    Matrix<T> plus(Matrix<T> m);
}
