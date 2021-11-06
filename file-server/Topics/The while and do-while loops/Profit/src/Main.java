import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        double m = sc.nextInt();
        double p = sc.nextInt()/100d;
        double k = sc.nextInt();
        double c = m;
        int y = 0;
        while (c < k) {
            c *= (1 + p);
            y++;
        }
        System.out.println(y);
    }
}
