package animals.cli;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface ExpressionChecker {
    boolean isExpression(String exp);

    static ExpressionChecker fromSet(String... expressions) {
        return new SetExpressionChecker(new HashSet<>(Arrays.asList(expressions)));
    }
    static ExpressionChecker fromSet(Set<String> messages) {
        return new SetExpressionChecker(messages);
    }
}
