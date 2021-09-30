import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'o', 'u', 'i', 'y');


    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var s = sc.nextLine();
        long sum = needTooAdd(s,Main::isVowel) + needTooAdd(s, c -> !isVowel(c));
        System.out.println(sum);
    }

    private static long needTooAdd(String s, Predicate<Character> symPredicate) {
        var lastVowelLength = 0;
        int l = s.length();
        var sum = 0L;
        for (int i = 0; i< l; i++) {
            var c = s.charAt(i);
            if (symPredicate.test(c)) {
                lastVowelLength++;
            } else {
                if (lastVowelLength > 2) {
                    sum += (lastVowelLength %2 == 0 ? lastVowelLength/2 - 1 : lastVowelLength/2);
                }
                lastVowelLength = 0;
            }
        }
        if (lastVowelLength > 2) {
                    sum += (lastVowelLength %2 == 0 ? lastVowelLength/2 - 1 : lastVowelLength/2);
                }
        return sum;
    }


    private static boolean isVowel(char c) {
        return VOWELS.contains(c);
    }
}
