package metro;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    private final List<String> stations;

    public StationsPrinter(List<String> stations) {
        final Deque<String> deque = new ArrayDeque<>(stations);
        deque.addFirst(DEPOT);
        this.stations = Collections.unmodifiableList(new ArrayList<>(deque));
    }

    @Override
    public void print() {
        List<List<String>> groups = buildGroups(stations);
        for (List<String> group : groups) {
            System.out.println(String.join(" - ", group));
        }
    }


    private static List<List<String>> buildGroups(List<String> stations) {
        List<List<String>> groups = new ArrayList<>();
        Iterator<String> it = stations.iterator();
        int i = 0;
        while (it.hasNext()) {
            String s = it.next();
            int size = groups.size();
            if (size <= i && i < stations.size() - 1) {
                LinkedList<String> list = new LinkedList<>();
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
