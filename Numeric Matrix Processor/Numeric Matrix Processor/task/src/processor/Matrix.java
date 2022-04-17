package processor;

public interface Matrix<T extends Number> {
    int getRows();

    int getColumns();

    T[][] data();

    String content();

    default T[] row(int index) {
        return data()[index];
    }
    
    T[] column(int index);
    
    Matrix<T> scalarMultiply(T k);

    Matrix<T> plus(Matrix<T> m);

    Matrix<T> times(Matrix<T> b);
    
    Matrix<T> transpose(TranspositionType type);
    
    T det();
}
