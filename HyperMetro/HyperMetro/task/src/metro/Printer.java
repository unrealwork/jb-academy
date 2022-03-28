package metro;

import java.util.List;

public interface Printer {
    void print();

     static Printer stations(final List<String> stations) {
        return new StationsPrinter(stations);
    }
}
