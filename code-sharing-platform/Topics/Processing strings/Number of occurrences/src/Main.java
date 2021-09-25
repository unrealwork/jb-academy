import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        final String line = sc.nextLine();
        final String substring = sc.nextLine();
        int freq = 0;
        int startIndex = -1;
        do {
            startIndex = line.indexOf(substring, startIndex);
            if (startIndex >= 0) {
                startIndex = startIndex + substring.length();
                freq++;
            }
            if (startIndex > line.length()) {
                break;
            }
        }
        while (startIndex > -1);
        System.out.println(freq);
    }
}
