package animals.cli;

import java.util.Set;

public class SetExpressionChecker implements ExpressionChecker {
    private final Set<String> expressions;

    public SetExpressionChecker(Set<String> expressions) {
        this.expressions = expressions;
    }

    @Override
    public boolean isExpression(String exp) {
        final String trimmed = exp.trim();
        return expressions.stream()
                .anyMatch(trimmed::equalsIgnoreCase);
    }
}
