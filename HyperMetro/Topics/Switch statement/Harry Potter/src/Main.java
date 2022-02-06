import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // put your code here
    try (Scanner sc = new Scanner(System.in)) {
      System.out.println(houseCharacteristic(sc.next()));
    }
  }

  private static String houseCharacteristic(final String house) {
    switch (house) {
      case "gryffindor":
        return "bravery";
      case "hufflepuff":
        return "loyalty";
      case "slytherin":
        return "cunning";
      case "ravenclaw":
        return "intellect";
      default:
        return "not a valid house";
    }
  }
}
