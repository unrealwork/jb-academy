package account.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ParsingUtil {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM-yyyy");

    private ParsingUtil() {
    }

    public static LocalDate parseDate(final String formattedDate) {
        return LocalDate.parse(formattedDate, DTF);
    }
}
