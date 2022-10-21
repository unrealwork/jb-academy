import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int countTriples = 0;
            for (int i = 0; i < n - 2; i++) {
                boolean isTriple = isTriple(arr, i);
                if (isTriple) {
                    countTriples++;
                }
            }
            System.out.println(countTriples);
        }
    }

    private static boolean isTriple(int[] arr, int i) {
        boolean isTriple = true;
        for (int j = 0; j < 2; j++) {
            if (arr[i + j] + 1 != arr[i + j + 1]) {
                isTriple = false;
                break;
            }
        }
        return isTriple;
    }
}
