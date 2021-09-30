import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isPalindrome(s) ? "yes" : "no");
    }

    private static boolean isPalindrome(String s) {
        final int middle = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;
        for (int i = 0; i < middle; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
}
