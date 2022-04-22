package animals.cli;

import java.util.Arrays;
import java.util.HashSet;

public interface ExpressionChecker {
    boolean isExpression(String exp);

    static ExpressionChecker fromSet(String... expressions) {
        return new SetExpressionChecker(new HashSet<>(Arrays.asList(expressions)));
    }
}
