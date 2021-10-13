import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/** App's entrypoint. */
public class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      Box box1 = readBox(scanner);
      Box box2 = readBox(scanner);
      if (canFit(box1, box2)) {
        System.out.println("Box 1 > Box 2");
      } else {
        if (canFit(box2, box1)) {
          System.out.println("Box 1 < Box 2");
        } else {
          System.out.println("Incompatible");
        }
      }
    }
  }

  private static Box readBox(Scanner scanner) {
    return Box.createBox(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
  }

  private static boolean canFit(Box box, Box otherBox) {
    for (Box rotatedBox1 : box.rotations()) {
      for (Box rotatedBox2 : otherBox.rotations()) {
        if (rotatedBox1.isFit(rotatedBox2)) {
          return true;
        }
      }
    }
    return false;
  }

  private static class Box {
    private final int width;
    private final int height;
    private final int depth;

    private Box(int a, int b, int c) {
      this.width = a;
      this.height = b;
      this.depth = c;
    }

    private static Box createBox(int a, int b, int c) {
      return new Box(a, b, c);
    }

    public boolean isFit(Box other) {
      return width > other.width && height > other.height && depth > other.depth;
    }

    public List<Box> rotations() {
      return List.of(
          this,
          new Box(width, depth, height),
          new Box(depth, width, height),
          new Box(depth, height, width),
          new Box(height, depth, width),
          new Box(height, width, depth));
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Box box = (Box) o;
      return width == box.width && height == box.height && depth == box.depth;
    }

    @Override
    public int hashCode() {
      return Objects.hash(width, height, depth);
    }
  }
}
