import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // put your code here
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int n = sc.nextInt();
            if (nums.containsKey(n)) {
                nums.put(n, nums.get(n) + 1);
            } else {
                nums.put(n, 1);
            }
        }
        boolean res = nums.keySet().stream().anyMatch(l -> {
            int r = 20 - l;
            if (r == l) {
                return nums.get(l) > 1;
            } else {
                return nums.containsKey(r);
            }
        });
        System.out.println(res);
    }
}
