import java.time.LocalTime;
import java.util.Scanner;


@SuppressWarnings("squid:S106")
class Main {
    public static final long MINUTES_PER_HOUR = 60;

    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            final TimeRange first = parseTimeRange(sc.next(), sc.next());
            final TimeRange second = parseTimeRange(sc.next(), sc.next());
            System.out.println(first.intersects(second));
        }
    }

    private static TimeRange parseTimeRange(String startTime, String endTime) {
        return new TimeRange(parseMinutes(startTime), parseMinutes(endTime));
    }

    private static long parseMinutes(final String time) {
        final LocalTime localTime = LocalTime.parse(time);
        return localTime.getHour() * MINUTES_PER_HOUR + localTime.getMinute();
    }

    private static class TimeRange {
        private final long start;
        private final long end;

        private TimeRange(long start, long end) {
            this.start = start;
            this.end = end;
        }
        
        private boolean isTimeInside(final long time) {
            return time >= start && time <= end;
        }

        private boolean intersects(final TimeRange tr) {
            return isTimeInside(tr.start) || isTimeInside(tr.end) || tr.isTimeInside(start) || tr.isTimeInside(end);
        }
    }
}
