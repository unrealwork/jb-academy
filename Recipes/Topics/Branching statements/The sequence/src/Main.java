import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            int size = sc.nextInt();
            int outputNumber = 1;
            int outputCount = 0;
            for (int i = 0; i < size; i++) {
                System.out.printf("%d ", outputNumber);
                outputCount++;
                if (outputCount == outputNumber) {
                    outputCount = 0;
                    outputNumber++;
                }
            }
        }
    }
}