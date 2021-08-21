import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        return countOccurrences(elem, list1) == countOccurrences(elem, list2);
    }

    private static int countOccurrences(int elem, List<Integer> elements) {
        int counter = 0;
        for (Integer listElem : elements) {
            if (listElem.equals(elem)) {
                counter++;
            }
        }
        return counter;
    }
}