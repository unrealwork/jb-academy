import java.util.Scanner;

@SuppressWarnings("squid:S106")
class Main {
    private Main() {
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean res = n > -15 && n <= 12 || n > 14 && n < 17 || n >= 19;
        System.out.println(res ? "True" : "False");
    }
}
