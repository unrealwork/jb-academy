import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static final List<String> DAYS =
      Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

  public static String getDayOfWeekName(int number) {
    // write your code here
    if (number > 0 && number < DAYS.size() + 1) {
      return DAYS.get(number - 1);
    }
    throw new IllegalArgumentException();
  }

  /* Do not change code below */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int dayNumber = scanner.nextInt();
    try {
      System.out.println(getDayOfWeekName(dayNumber));
    } catch (Exception e) {
      System.out.println(e.getClass().getName());
    }
  }
}
