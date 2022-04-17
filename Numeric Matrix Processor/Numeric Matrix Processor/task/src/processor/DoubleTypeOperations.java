package processor;

public class DoubleTypeOperations implements TypeOperations<Double> {
    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double zero() {
        return 0d;
    }

    @Override
    public Double one() {
        return 1d;
    }

    @Override
    public Double inverseAdd(Double a) {
        return -a;
    }

    @Override
    public Double inverseMult(Double a) {
        return 1/a;
    }

    @Override
    public Class<Double> typeClass() {
        return Double.class;
    }
}
