import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            int middle = size / 2;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    boolean isStar = i == middle || j == middle ||
                            i == j || (i + j + 1 == size);
                    sb.append(isStar ? '*' : '.');
                    sb.append(' ');
                }
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
        }
    }
}
