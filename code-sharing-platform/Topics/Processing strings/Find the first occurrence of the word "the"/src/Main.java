import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            final String sentence = sc.nextLine();
            System.out.println(sentence.toLowerCase().indexOf("the"));
        }
    }
}
