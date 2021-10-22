import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // put your code here
    final boolean res = IntStream.range(0, 3).map(n -> scanner.nextInt()).distinct().count() == 3;
    System.out.println(res);
  }
}
