package processor;

public class NotMatchingDimensionsException extends RuntimeException {
    public NotMatchingDimensionsException(String s) {
        super(s);
    }

    public NotMatchingDimensionsException() {
        super();
    }
}
