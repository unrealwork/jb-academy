import java.util.Optional;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        InputStringReader reader = new InputStringReader();        
        Optional<String> value = reader.getValue();
        if (value.isPresent()) {
            System.out.println("Value is present: " + value.get());
        } else {
            System.out.println("Value is empty");
        }
    }
}

class InputStringReader {
    public Optional<String> getValue() {
        // implement
        final Scanner scanner = new Scanner(System.in);
        try {
            final String value = scanner.nextLine();
            if (value == null || "empty".equals(value)) {
                return Optional.empty();
            }
            return Optional.of(value);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}