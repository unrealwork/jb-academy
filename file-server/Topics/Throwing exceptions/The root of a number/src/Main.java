import java.util.Scanner;

public class Main {

  public static double sqrt(double x) {
    // write your code here
    if (x < 0) {
      throw new IllegalArgumentException(String.format("Expected non-negative number, got %s", 
              Double.toString(x)));
    }
    return Math.sqrt(x);
  }

  /* Do not change code below */
  public static void main(String[] args) {
    String value = new Scanner(System.in).nextLine();
    try {
      double res = sqrt(Double.parseDouble(value));
      System.out.println(res);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
