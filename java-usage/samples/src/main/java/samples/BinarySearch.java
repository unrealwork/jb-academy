package samples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        try (Scanner sc = new Scanner(Files.newInputStream(path))) {
            List<Integer> integers = new LinkedList<>();
            while (sc.hasNextInt()) {
                integers.add(sc.nextInt());
            }
            System.out.println(binaryComparisons(integers.stream().mapToInt(Integer::intValue).toArray(), 6));
        }
    }

    private static int binaryComparisons(int[] array, int finishIndex) {
        int left = 0;
        int right = array.length - 1;
        int comparisons = 0;
        while (right >= left) {
            int middle = (right + left) / 2;
            comparisons++;
            if (array[middle] == array[finishIndex]) {
                return comparisons;
            }
            if (middle > finishIndex) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return comparisons;
    }
}
