import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int prevHeight = -1;
        Boolean isAsc = null;
        for (int i = 0; i < 3; i++) {
            int height = scanner.nextInt();
            if (prevHeight == -1) {
                prevHeight = height;
            } else {
                if (isAsc == null) {
                    isAsc = (prevHeight <= height);
                } else {
                    if (isAsc && height < prevHeight || !isAsc && height > prevHeight) {
                        System.out.println(false);
                        return;
                    }
                }
                prevHeight = height;
            }
        }
        System.out.println(true);
    }
}
