package blockchain;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int requiredZeros = askForZeroes();
        BlockChain chain = BlockChain.withSize(5, requiredZeros);
        Iterator<BlockChain.Block> it = chain.iterator();
        int i = 0;
        while (it.hasNext() && i < 5) {
            System.out.println(it.next());
            i++;
        }
    }

    private static int askForZeroes() {
        System.out.print("Enter how many zeros the hash must start with: ");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        }
    }
}
