package metro.printer;

import metro.model.Station;
import metro.model.Transfer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

class StationsPrinter implements Printer {
    public static final Station DEPOT = new Station("depot");
    private final List<Station> stations;

    public StationsPrinter(List<Station> stations) {
        final Deque<Station> deque = new ArrayDeque<>(stations);
        deque.addFirst(DEPOT);
        this.stations = Collections.unmodifiableList(new ArrayList<>(deque));
    }

    @Override
    public void print() {
        for (Station station : stations) {
            System.out.println(printStation(station));
        }
        System.out.println(printStation(DEPOT));
    }


    private String printStation(Station station) {
        if (station == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder(station.getName());
        final List<Transfer> transfer = station.getTransfer();
        if (transfer != null && !transfer.isEmpty()) {
            for (Transfer t : transfer) {

                sb.append(" - ")
                        .append(t.getStation())
                        .append(" (")
                        .append(t.getLine())
                        .append(")");
            }
        }
        return sb.toString();
    }

}
