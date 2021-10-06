import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println(sc.nextInt() > 0 ? "YES" : "NO");
        }
    }
}
