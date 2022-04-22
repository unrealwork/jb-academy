package animals.cli.greeting;

import java.time.LocalTime;

enum TimeBasedGreeting implements Greeting {
    MORNING("Good morning!", DayTimes.MORNING, DayTimes.AFTERNOON),
    AFTERNOON("Good afternoon!", DayTimes.AFTERNOON, DayTimes.EVENING),
    EVENING("Good evening!", DayTimes.EVENING, DayTimes.MORNING);
    private final String message;
    private final LocalTime start;
    private final LocalTime end;

    TimeBasedGreeting(String message, LocalTime start, LocalTime end) {
        this.message = message;
        this.start = start;
        this.end = end;
    }

    public boolean isGreetingTime(LocalTime lt) {
        if (end.isAfter(start)) {
            return lt.isAfter(start) && lt.isBefore(end);
        } else {
            return lt.isAfter(end) || lt.isBefore(start);
        }
    }

    @Override
    public String message() {
        return message;
    }
}
