import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;

class Playground {
    public static void main(String[ ] args) {
        Instant instant  = Instant.EPOCH;
        instant.minus(Period.ofDays(1));

        System.out.println(instant.minus(Duration.ofDays(32)).atZone(ZoneId.of("GMT+6")));
    }
}
