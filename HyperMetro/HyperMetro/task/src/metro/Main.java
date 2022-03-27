package metro;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        Path pathToFile = Paths.get(args[0]);
        SubwayStorage subwayStorage = SubwayStorage.fromJsonFile(pathToFile);
        if (Files.exists(pathToFile)) {
            final List<String> stations = readStations(pathToFile);
            List<List<String>> groups = buildGroups(stations);
            for (List<String> group : groups) {
                System.out.println(String.join(" - ", group));
            }
        } else {
            System.out.println("Error! Such a file doesn't exist!:");
        }
    }

    private static List<String> readStations(Path pathToFile) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
            List<String> lines = reader
                    .lines()
                    .collect(Collectors.toList());
            List<String> stations = new LinkedList<>();
            stations.add("depot");
            stations.addAll(lines);
            return stations;
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
