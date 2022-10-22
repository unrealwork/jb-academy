import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        subtractFromEpoch(scanner.nextInt(), scanner.next());
    }

    public static void subtractFromEpoch(int days, String zone) {
        ZoneId zoneId = ZoneId.of(zone);
        ZonedDateTime zdt = Instant.EPOCH.minus(Period.ofDays(days)).atZone(zoneId);
        System.out.println(zdt);
    }
}
