package metro.printer;

import metro.model.Station;
import metro.route.Route;

import java.util.List;

public interface Printer {
    static Printer route(Route route) {
        return new RouterPrinter(route);
    }

    void print();

    static Printer stations(final List<Station> stations) {
        return new StationsPrinter(stations);
    }
}
