import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {
    public static void main(String[] args) {
        Stream<Integer> ints = IntStream.of(2,3,1).boxed();
        findMinMax(ints, Comparator.naturalOrder(), (min, max) -> {
            System.out.println(min + " " + max);
        });
    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        stream.reduce(MinMaxHolder.<T>empty(order), MinMaxHolder::next, (h1, h2) -> h2)
                .consume(minMaxConsumer);

    }

    private static class MinMaxHolder<T> {
        private final T min;
        private final T max;
        private final Comparator<? super T> order;

        private MinMaxHolder(Comparator<? super T> comparator) {
            this(null, null, comparator);
        }

        public MinMaxHolder(T min, T max, Comparator<? super T> order) {
            this.min = min;
            this.max = max;
            this.order = order;
        }

        static <T> MinMaxHolder<T> empty(Comparator<? super T> comparator) {
            return new MinMaxHolder<>(comparator);
        }

        MinMaxHolder<T> next(T value) {
            return new MinMaxHolder<>(nextMin(value), nextMax(value), order);
        }

        private T nextMin(T value) {
            if (min == null) {
                return value;
            }
            return order.compare(min, value) > 0 ? value : min;
        }

        private T nextMax(T value) {
            if (min == null) {
                return value;
            }
            return order.compare(value, max) > 0 ? value : max;
        }

        public void consume(BiConsumer<? super T, ? super T> minMaxConsumer) {
            minMaxConsumer.accept(min, max);
        }
    }
}
