
class InputReader {
    public static String getString() {
        // write your code 
        try (var scanner = new java.util.Scanner(System.in)) {
            return scanner.nextLine();
        }
    }
}
