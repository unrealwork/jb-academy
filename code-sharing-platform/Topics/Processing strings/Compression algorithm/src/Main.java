import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            final String line = scanner.nextLine();
            char currentSymbol = line.charAt(0);
            int currentCount = 1;
            final StringBuilder sb = new StringBuilder();
            for (int i = 1; i < line.length(); i++) {
                final char newSymbol = line.charAt(i);
                if (currentSymbol == newSymbol) {
                    currentCount++;
                } else {
                    sb.append(currentSymbol);
                    sb.append(currentCount);
                    currentCount = 1;
                    currentSymbol = newSymbol;
                }
            }
            sb.append(currentSymbol);
            sb.append(currentCount);
            System.out.println(sb);
        }
    }
}
