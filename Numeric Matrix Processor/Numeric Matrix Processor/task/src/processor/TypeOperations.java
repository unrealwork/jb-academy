package processor;

public interface TypeOperations<T> {
    T add(T a, T b);

    T multiply(T a, T b);

    T zero();

    T one();

    T negate(T a);

    default T negateOne() {
        return negate(one());
    }

    default T minus(T a, T b) {
        return add(a, negate(b));
    }

    Class<T> typeClass();

    static TypeOperations<Integer> integers() {
        return new IntTypeOperations();
    }

    static TypeOperations<Double> doubles() {
        return new DoubleTypeOperations();
    }
}
