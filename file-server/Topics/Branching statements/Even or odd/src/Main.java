import java.util.Scanner;

@SuppressWarnings("squid:S106")
class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            while (n != 0) {
                System.out.println(n % 2 == 0 ? "even" : "odd");
                n = sc.nextInt();
            }
        }
    }
}
