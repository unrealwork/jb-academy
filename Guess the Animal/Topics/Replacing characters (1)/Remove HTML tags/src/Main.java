import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final String content = scanner.nextLine();
            final String res = content.replaceAll("</?[^</>]+>", "");
            System.out.println(res);
        }
    }
}
