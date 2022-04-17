package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                provideChoice(scanner);
            }
        } catch (NotMatchingDimensionsException e) {
            System.out.println("ERROR");
        }
    }

    private static void provideChoice(Scanner it) {
        for (Operation op : Operation.values()) {
            System.out.println(op.getChoice() + ". " + op.getTitle());
        }
        System.out.print("Your choice: ");
        final Operation operation = Operation.byChoice(it.nextInt());
        try {
            switch (operation) {
                case ADD:
                    addCommand(it);
                    break;
                case SCALAR:
                    scalarMultiplyCommand(it);
                    break;
                case TIMES:
                    timesCommand(it);
                    break;
                case TRANSPOSE:
                    transposeCommand(it);
                    break;
                case DETERMINANT:
                    determinantCommand(it);
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Invalid option");
            }
        } catch (Exception e) {
            System.out.println("The operation cannot be performed.");
        }
    }

    private static void determinantCommand(Scanner it) {
        
    }

    private static void printMenuOptions(MenuEntry... ops) {
        for (MenuEntry op : ops) {
            System.out.println(op.getChoice() + ". " + op.getTitle());
        }
    }

    private static void transposeCommand(Scanner it) {
        printMenuOptions(TransposeOperation.values());
        System.out.print("Your choice: ");
        TransposeOperation transposeOperation = TransposeOperation.byChoice(it.nextInt());
        System.out.print("Enter size of matrix: ");
        final int rows = it.nextInt();
        final int columns = it.nextInt();
        System.out.println("Enter matrix:");
        final Matrix<Double> a = IOUtil.readDoubleMatrix(it, rows, columns);
        System.out.println("The result is:");
        System.out.println(a.transpose(transposeOperation.getType()).content());
    }

    private static void timesCommand(Scanner it) {
        System.out.print("Enter size of first matrix: ");
        int rows = it.nextInt();
        int columns = it.nextInt();
        System.out.println("Enter first matrix:");
        Matrix<Double> a = IOUtil.readDoubleMatrix(it, rows, columns);
        System.out.print("Enter size of second matrix: ");
        rows = it.nextInt();
        columns = it.nextInt();
        System.out.println("Enter second matrix:");
        Matrix<Double> b = IOUtil.readDoubleMatrix(it, rows, columns);
        System.out.println("The result is:");
        System.out.println(a.times(b).content());
    }

    private static void scalarMultiplyCommand(Scanner it) {
        System.out.print("Enter size of matrix: ");
        int rows = it.nextInt();
        int columns = it.nextInt();
        System.out.println("Enter matrix:");
        Matrix<Double> a = IOUtil.readDoubleMatrix(it, rows, columns);
        System.out.print("Enter constant: ");
        double scalar = it.nextDouble();
        System.out.println("The result is:");
        System.out.println(a.scalarMultiply(scalar).content());
    }

    private static void addCommand(Scanner it) {
        System.out.print("Enter size of first matrix: ");
        int rows = it.nextInt();
        int columns = it.nextInt();
        System.out.println("Enter first matrix:");
        Matrix<Double> a = IOUtil.readDoubleMatrix(it, rows, columns);
        System.out.print("Enter size of second matrix: ");
        rows = it.nextInt();
        columns = it.nextInt();
        System.out.println("Enter second matrix:");
        Matrix<Double> b = IOUtil.readDoubleMatrix(it, rows, columns);
        System.out.println("The result is:");
        System.out.println(a.plus(b).content());
    }
}
