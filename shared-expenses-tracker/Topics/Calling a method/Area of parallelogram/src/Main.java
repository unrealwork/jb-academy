import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // call the method here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        countAreaOfParallelogram(a, b);
    }

    // Do not change code below   
    public static void countAreaOfParallelogram(int b, int h) {
        System.out.println(b * h);
    }
}
