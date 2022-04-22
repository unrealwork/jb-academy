package animals.cli.greeting;

import java.time.LocalTime;
import java.util.Arrays;

public interface Greeting {
    String message();

    static Greeting fromLocalTime() {
        final LocalTime now = LocalTime.now();
        return Arrays.stream(TimeBasedGreeting.values())
                .filter(g -> g.isGreetingTime(now))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Unsupported time for greeting"));
    }
}
