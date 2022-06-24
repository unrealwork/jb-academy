import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int[] arr = new int[scanner.nextInt()];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        arr[0] = scanner.nextInt();

        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}
