package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            IntMatrix a = IntMatrix.read(scanner);
            int k = scanner.nextInt();
            System.out.println(a.scalarMultiply(k).content());
        } catch (NotMatchingDimensionsException e) {
            System.out.println("ERROR");
        }
    }
}
