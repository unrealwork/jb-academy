package animals.cli.greeting;

import animals.storage.MessageKeys;

import java.time.LocalTime;

import static animals.i18n.ResourceBundles.MSG;

enum TimeBasedGreeting implements Greeting {
    MORNING(MessageKeys.GREETING_MORNING, DayTimes.MORNING, DayTimes.AFTERNOON),
    AFTERNOON(MessageKeys.GREETING_AFTERNOON, DayTimes.AFTERNOON, DayTimes.EVENING),
    EVENING(MessageKeys.GREETING_EVENING, DayTimes.EVENING, DayTimes.MORNING);
    private final String messageKey;
    private final LocalTime start;
    private final LocalTime end;

    TimeBasedGreeting(String messageKey, LocalTime start, LocalTime end) {
        this.messageKey = messageKey;
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
        return MSG.getString(messageKey);
    }
}
