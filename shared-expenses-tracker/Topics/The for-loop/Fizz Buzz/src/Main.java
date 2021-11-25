import java.util.Scanner;

class Main {
    @SuppressWarnings("squid:S106")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        for (int i = start; i <= end; i++) {
            boolean isMultipleThree = (i % 3 == 0);
            boolean isMultipleFive = (i % 5 == 0);
            String next;
            if (isMultipleThree && isMultipleFive) {
                next = "FizzBuzz";
            } else {
                if (isMultipleThree) {
                    next = "Fizz";
                } else {
                    if (isMultipleFive) {
                        next = "Buzz";
                    } else {
                        next = Integer.toString(i);
                    }
                }
            }
            System.out.println(next);
        }
    }
}
