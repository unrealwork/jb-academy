import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your code here
        int n = scanner.nextInt();
        String res = switch (n) {
            case 1:
                yield "January";
            case 2:
                yield "February";
            case 3:
                yield "March";
            case 4:
                yield "April";
            case 5:
                yield "May";
            case 6:
                yield "June";
            default:
                yield "error!";
        };
        System.out.println(res);
    }
}
