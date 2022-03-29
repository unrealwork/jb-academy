package metro;

import java.util.List;

public interface Printer {
    void print();

     static Printer stations(final List<Station> stations) {
        return new StationsPrinter(stations);
    }
}
