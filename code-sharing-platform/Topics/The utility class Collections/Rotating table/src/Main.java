import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            int rowsNumber = sc.nextInt();
            int columnNumber = sc.nextInt();
            final List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < rowsNumber; i++) {
                List<Integer> subList = new ArrayList<>(columnNumber);
                for (int j = 0; j < columnNumber; j++) {
                    subList.add(sc.nextInt());
                }
                list.add(subList);
            }
            rotate(list, sc.nextInt());
            print(list);
        }
    }

    private static void print(List<List<Integer>> list) {
        for (List<Integer> subList : list) {
            for (Integer n : subList) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static <T> void rotate(List<T> list, int rotationDistance) {
        int normalizedRD = rotationDistance % list.size();
        int swapDistance = 0;
        for (int i = 0; i < list.size(); i++) {
            swapDistance += normalizedRD;
            Collections.swap(list, 0, swapDistance % list.size());
        }
    }
}
