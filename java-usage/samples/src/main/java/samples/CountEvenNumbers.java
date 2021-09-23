package samples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountEvenNumbers {
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(args[0]);
        try (Scanner scanner = new Scanner(Files.newInputStream(path))) {
            int evenNumberCount = 0;
            while (scanner.hasNextInt()) {
                final int n = scanner.nextInt();
                if (n == 0) {
                    break;
                }
                if (n % 2 == 0) {
                    evenNumberCount++;
                }
            }
            System.out.println(evenNumberCount);
        }
    }
}
