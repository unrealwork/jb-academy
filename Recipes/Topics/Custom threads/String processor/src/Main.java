import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        // implement this method
        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            final String line = scanner.nextLine();
            boolean containsLowerCaseLetters = line.chars()
                    .anyMatch(code -> code >= 'a' && code <= 'z');
            if (containsLowerCaseLetters) {
                System.out.println(line.toUpperCase());
            } else {
                break;
            }
        }
        System.out.println("FINISHED");
    }
}
