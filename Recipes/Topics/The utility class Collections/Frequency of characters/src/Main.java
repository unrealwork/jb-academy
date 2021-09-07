import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        try (Scanner sc = new Scanner(System.in)) {
            final List<String> symbols = List.of(sc.nextLine().split("\\s+"));
            final String symbolToFind = sc.next();
            System.out.println(Collections.frequency(symbols, symbolToFind));
        }
    }
}
