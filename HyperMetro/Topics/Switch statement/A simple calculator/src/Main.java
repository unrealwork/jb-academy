import java.util.Scanner;
import java.util.function.LongBinaryOperator;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        long a = scanner.nextLong();
        char op = scanner.next().trim().charAt(0);
        long b = scanner.nextLong();
        try {
            System.out.println(op(op).applyAsLong(a, b));
        } catch (UnknownOperatorException e) {
            System.out.println("Unknown operator");
        } catch (ArithmeticException e) {
            System.out.println("Division by 0!");
        }
    }

    private static class UnknownOperatorException extends Exception {
    }

    private static LongBinaryOperator op(char c) throws UnknownOperatorException {
        switch (c) {
            case '*':
                return (a, b) -> a * b;
            case '-':
                return (a, b) -> a - b;
            case '+':
                return Long::sum;
            case '/':
                return (a, b) -> a / b;
            default:
                throw new UnknownOperatorException();
        }
    }
}
