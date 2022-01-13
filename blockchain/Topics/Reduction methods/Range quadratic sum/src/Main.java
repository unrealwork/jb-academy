import java.util.stream.IntStream;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        return IntStream.range(fromIncl, toExcl)
                .map(i -> i * i)
                .sum();// write your code with streams here
    }
}
