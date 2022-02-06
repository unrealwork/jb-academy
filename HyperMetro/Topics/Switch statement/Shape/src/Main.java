import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        try {
            var type = typeById(scanner.nextInt());
            System.out.printf("You have chosen a %s%n", type);
        } catch (Exception e) {
            System.out.println("There is no such shape!");
        }

    }

    private static String typeById(final int typeId) {
        switch (typeId) {
            case 1:
                return "square";
            case 2:
                return "circle";
            case 3:
                return "triangle";
            case 4:
                return "rhombus";
            default:
                throw new IllegalArgumentException();
        }
    }
}
