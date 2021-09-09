import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<>() {
            private final AtomicInteger counter = new AtomicInteger();

            @Override
            public Integer get() {
                return counter.getAndIncrement();
            }
        };
    }

}
