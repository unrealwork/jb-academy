import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Collections.indexOfSubList;
import static java.util.Collections.lastIndexOfSubList;

class Main {
    public static void main(String[] args) {
        // put your code here
        final Scanner scanner = new Scanner(System.in);
        final List<Integer> seq1 = parseNumberList(scanner.nextLine());
        final List<Integer> seq2 = parseNumberList(scanner.nextLine());
        System.out.println(indexOfSubList(seq1, seq2) + " " + lastIndexOfSubList(seq1, seq2));
    }

    private static List<Integer> parseNumberList(final String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
