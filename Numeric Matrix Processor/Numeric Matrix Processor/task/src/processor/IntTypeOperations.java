package processor;

public class IntTypeOperations implements TypeOperations<Integer> {
    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer zero() {
        return 0;
    }

    @Override
    public Integer one() {
        return 1;
    }

    @Override
    public Integer inverseAdd(Integer a) {
        return -a;
    }

    @Override
    public Integer inverseMult(Integer a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class<Integer> typeClass() {
        return Integer.class;
    }
}
