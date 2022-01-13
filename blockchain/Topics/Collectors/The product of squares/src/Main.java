import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class CollectorProduct {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String val : values) {
            numbers.add(Integer.parseInt(val));
        }

        long val = numbers.stream().collect(
                // Write your collector 
                Collectors.reducing(1L, (Integer a) -> a.longValue() * a, (number, number2) -> number * number2)
        );

        System.out.println(val);
    }
}
