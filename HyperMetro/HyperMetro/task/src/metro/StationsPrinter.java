package metro;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class StationsPrinter implements Printer {
    public static final String DEPOT = "depot";
    private final List<Station> stations;

    public StationsPrinter(List<Station> stations) {
        final Deque<Station> deque = new ArrayDeque<>(stations);
        deque.addFirst(new Station(DEPOT));
        this.stations = Collections.unmodifiableList(new ArrayList<>(deque));
    }

    @Override
    public void print() {
        final List<List<Station>> groups = buildGroups(stations);
        for (List<Station> group : groups) {
            final String groupDesc = group.stream()
                    .map(this::printStation)
                    .collect(Collectors.joining(" - "));
            System.out.println(groupDesc);
        }
    }


    private String printStation(Station station) {
        if (station == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder(station.getName());
        final List<Transfer> transfer = station.getTransfer();
        if (transfer != null && !transfer.isEmpty()) {
            sb.append(" (");
            for (Iterator<Transfer> iterator = transfer.iterator(); iterator.hasNext(); ) {
                Transfer t = iterator.next();

                sb.append(t.getLine());
                if (iterator.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    private static List<List<Station>> buildGroups(List<Station> stations) {
        List<List<Station>> groups = new ArrayList<>();
        Iterator<Station> it = stations.iterator();
        int i = 0;
        while (it.hasNext()) {
            Station s = it.next();
            int size = groups.size();
            if (size <= i && i < stations.size() - 1) {
                LinkedList<Station> list = new LinkedList<>();
                list.add(s);
                groups.add(list);
            }
            if (i > 0) {
                if (size > 1 && i < groups.size() + 2) {
                    groups.get(i - 2).add(s);
                }
                if (size > 0 && i < groups.size() + 1) {
                    groups.get(i - 1).add(s);
                }
            }
            i++;
        }
        if (!stations.isEmpty() && !groups.isEmpty()) {
            groups.get(groups.size() - 1).add(stations.get(0));
        }
        return groups;
    }
}
