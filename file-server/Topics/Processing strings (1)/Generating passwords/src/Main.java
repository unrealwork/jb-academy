import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // write your code here
    try (Scanner sc = new Scanner(System.in)) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int n = sc.nextInt();
      PasswordGenerator passwordGenerator = new PasswordGenerator(a, b, c, n);
      System.out.println(passwordGenerator.generate());
    }
  }

  interface Generator<T> {
    T generate();
  }

  static class UpperCaseGenerator implements Generator<Character> {
    private final Random random = new Random();

    @Override
    public Character generate() {
      return (char) (random.nextInt('Z' - 'A') + 'A');
    }
  }

  static class LowerCaseGenerator implements Generator<Character> {
    private final Random random = new Random();

    @Override
    public Character generate() {
      return (char) (random.nextInt('z' - 'a') + 'a');
    }
  }

  static class DigitGenerator implements Generator<Character> {
    private final Random random = new Random();

    @Override
    public Character generate() {
      return (char) (random.nextInt('9' - '0') + '0');
    }
  }

  static class PasswordGenerator implements Generator<String> {
    private final int minimumUpperCount;
    private final int minimumLowerCount;
    private final int minimumDigitCount;
    private final int length;
    private final List<Generator<Character>> symbolGenerators;
    private final Random random = new Random();

    PasswordGenerator(
        int minimumUpperCount, int minimumLowerCount, int minimumDigitCount, int length) {
      this.minimumUpperCount = minimumUpperCount;
      this.minimumLowerCount = minimumLowerCount;
      this.minimumDigitCount = minimumDigitCount;
      this.length = length;
      this.symbolGenerators =
          Arrays.asList(new UpperCaseGenerator(), new LowerCaseGenerator(), new DigitGenerator());
    }

    @Override
    public String generate() {
      int u = 0;
      int l = 0;
      int d = 0;
      char[] chars = new char[length];
      for (int i = 0; i < length; i++) {
        if (u < minimumUpperCount) {
          chars[i] = symbolGenerators.get(0).generate();
          u++;
        } else {
          if (l < minimumLowerCount) {
            chars[i] = symbolGenerators.get(1).generate();
            l++;
          } else {
            if (d < minimumDigitCount) {
              chars[i] = symbolGenerators.get(2).generate();
              d++;
            } else {
              chars[i] = symbolGenerators.get(random.nextInt(3)).generate();
            }
          }
        }
      }
      shuffle(chars);
      if (length > 2 && chars[length - 1] == chars[length - 2]) {
        return generate();
      }

      return new String(chars);
    }

    private void shuffle(char[] chars) {
      for (int i = 0; i < chars.length - 1; i++) {
        int randomNext = random.nextInt(chars.length - i - 1) + i + 1;
        if (i > 0) {
          while (chars[i - 1] == chars[randomNext]) {
            randomNext = random.nextInt(chars.length - i - 1) + i + 1;
          }
        }
        swap(i, randomNext, chars);
      }
    }

    private void swap(int i, int j, char[] chars) {
      char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;
    }
  }
}
