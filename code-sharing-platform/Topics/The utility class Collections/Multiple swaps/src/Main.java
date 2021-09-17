import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list = new ArrayList<>(nums);
        int swapAmount = sc.nextInt();
        for (int i = 0; i < swapAmount; i++) {
            Collections.swap(list, sc.nextInt(), sc.nextInt());
        }
        list.forEach(n -> System.out.print(n + " "));
    }
}
