import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            Arrays.stream(sc.nextLine().split(" "))
                    .max(Comparator.comparing(String::length))
                    .ifPresent(System.out::println);
        }
    }
}
