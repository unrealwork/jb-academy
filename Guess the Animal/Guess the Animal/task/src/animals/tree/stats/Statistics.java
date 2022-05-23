package animals.tree.stats;

import animals.lang.Fact;

public final class Statistics {
    private Statistics() {

    }

    public static Statistic integer(int val) {
        return () -> val;
    }

    public static Statistic real(double val) {
        return () -> val;
    }

    public static Statistic fact(Fact fact) {
        return () -> fact.exp(true).asText();
    }
}
