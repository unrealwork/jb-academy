import java.util.List;
import java.util.Optional;

class Main {
    public static void main(String[] args) {
        ValueProvider provider = new ValueProvider();
        // use provider.getValues() to get List<Optional<Integer>>
        long sum = provider.getValues().stream().filter(Optional::isPresent)
                .map(Optional::get)
                .mapToLong(Integer::longValue)
                .sum();
        System.out.println(sum);
    }
}
