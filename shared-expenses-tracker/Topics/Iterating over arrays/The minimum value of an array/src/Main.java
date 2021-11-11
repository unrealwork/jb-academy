import java.util.Scanner;

@SuppressWarnings("squid:S106")
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int min = sc.nextInt();
        for (int i = 1; i < size; i++) {
            int num = sc.nextInt();
            if (num < min) {
                min = num;
            }
        }
        System.out.println(min);
    }
}
