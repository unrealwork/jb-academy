import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        List<Integer> seq = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int next = scanner.nextInt();
            while (next != 0) {
                seq.add(next);
                next = scanner.nextInt();
            }
        }
        int[] array = seq.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(isOrdered(array));
    }


    private static boolean isOrdered(int[] seq) {
        boolean hasFirstShift = false;
        boolean isAsc = false;
        for (int i = 1; i < seq.length; i++) {
            if (!hasFirstShift) {
                if (seq[i] != seq[i - 1]) {
                    hasFirstShift = true;
                    isAsc = seq[i] > seq[i - 1];
                }
            } else {
                if (isAsc) {
                    if (seq[i] < seq[i - 1]) {
                        return false;
                    }
                } else {
                    if (seq[i] > seq[i - 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
