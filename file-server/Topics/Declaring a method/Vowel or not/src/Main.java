import java.util.Scanner;
import java.util.Set;

public class Main {

    public static boolean isVowel(char ch) {
        // write your code here
        return Set.of('a', 'e', 'i', 'u', 'o').contains(Character.toLowerCase(ch));
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}
