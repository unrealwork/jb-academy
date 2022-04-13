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
    public Class<Double> typeClass() {
        return Double.class;
    }
}
