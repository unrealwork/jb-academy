package processor;

public interface TypeOperations<T> {
    T add(T a, T b);

    T multiply(T a, T b);
    
    T zero();

    Class<T> typeClass();
    
    static TypeOperations<Integer> integers() {
        return new IntTypeOperations();
    }

    static TypeOperations<Double> doubles() {
        return new DoubleTypeOperations();
    }
}
