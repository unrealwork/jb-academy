import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        List<String> list = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
        }
        System.out.println(list);
    }
}
