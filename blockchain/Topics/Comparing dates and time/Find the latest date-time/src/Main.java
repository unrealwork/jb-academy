import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    private static final ThreadLocal<DateTimeFormatter> FORMATTER = ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

    public static void main(String[] args) {
        // put your code her

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            LocalDateTime latestDateTime = null;
            for (int i = 0; i < n; i++) {
                final String dtText = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(dtText, FORMATTER.get());
                if (latestDateTime == null || dateTime.isAfter(latestDateTime)) {
                    latestDateTime = dateTime;
                }
            }
            System.out.println(latestDateTime);
        }
    }
}
