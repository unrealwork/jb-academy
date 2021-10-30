import java.util.EnumMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("squid:S106")
public final class Main {
    private Main() {
    }


    public static void main(final String[] args) {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();
            PasswordGenerator passwordGenerator = new PasswordGenerator(a, b, c, n, new Random());
            System.out.println(passwordGenerator.generate());
        }
    }

    enum SymbolType { UPPER, LOWER, DIGIT }

    interface Generator<T> {
        T generate();
    }

    static class RangeCharacterGenerator implements Generator<Character> {
        private final char lower;
        private final char upper;
        private final Random random;

        RangeCharacterGenerator(char lower, char upper, Random random) {
            this.lower = lower;
            this.upper = upper;
            this.random = random;
        }

        @Override
        public Character generate() {
            return (char) (random.nextInt(upper - lower) + lower);
        }
    }

    static class PasswordGenerator implements Generator<String> {
        private final int minimumUpperCount;
        private final int minimumLowerCount;
        private final int minimumDigitCount;
        private final int length;
        private final Random random;
        private final SymbolGeneratorFactory symbolGeneratorFactory;

        PasswordGenerator(final int a, final int b, final int c, final int n, Random random) {
            this.minimumUpperCount = a;
            this.minimumLowerCount = b;
            this.minimumDigitCount = c;
            this.length = n;
            this.random = random;
            this.symbolGeneratorFactory = SymbolGeneratorFactory.withRandom(random);
        }

        @Override
        public String generate() {
            char[] chars = new char[length];
            int g = 0;
            for (int i = g; i < minimumUpperCount; i++) {
                chars[i] = symbolGeneratorFactory.get(SymbolType.UPPER)
                        .generate();
            }
            g += minimumUpperCount;
            for (int i = g; i < g + minimumLowerCount; i++) {
                chars[i] = symbolGeneratorFactory.get(SymbolType.LOWER)
                        .generate();
            }
            g += minimumLowerCount;
            for (int i = g; i < g + minimumDigitCount; i++) {
                chars[i] = symbolGeneratorFactory.get(SymbolType.DIGIT)
                        .generate();
            }
            g += minimumDigitCount;
            for (int i = g; i < length; i++) {
                chars[i] = symbolGeneratorFactory.randomGenerator()
                        .generate();
            }
            shuffle(chars);
            if (length > 1 && chars[length - 1] == chars[length - 2]) {
                return generate();
            }

            return new String(chars);
        }

        private void shuffle(final char[] chars) {
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

        private void swap(final int i, final int j, final char[] chars) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }

    static class SymbolGeneratorFactory {
        private final Random random;
        private final Map<SymbolType, Generator<Character>> storage = new EnumMap<>(SymbolType.class);

        private SymbolGeneratorFactory(Random random) {
            this.random = random;
        }

        static Main.SymbolGeneratorFactory withRandom(Random random) {
            return new Main.SymbolGeneratorFactory(random);
        }

        Generator<Character> get(SymbolType type) {
            switch (type) {
                case UPPER:
                    return storage.computeIfAbsent(type,
                            k -> new RangeCharacterGenerator('A', 'Z', random));
                case LOWER:
                    return storage.computeIfAbsent(type,
                            k -> new RangeCharacterGenerator('a', 'z', random));
                case DIGIT:
                    return storage.computeIfAbsent(type,
                            k -> new RangeCharacterGenerator('0', '9', random));
                default:
                    throw new IllegalArgumentException("Unsupported type to generate");
            }
        }

        Generator<Character> randomGenerator() {
            final SymbolType randomType = SymbolType.values()[random.nextInt(SymbolType.values().length)];
            return this.get(randomType);
        }
    }
}
