import java.util.Optional;

class Main {
    public static void main(String[] args) {
        ValueProvider provider = new ValueProvider();
        // use provider.getValue() to get Optional<String>
        final Optional<String> res = provider.getValue();
        res.ifPresent(System.out::println);
    }
}