package animals.cli;

import animals.Expression;
import animals.IllegalExpression;

import java.util.Set;

public class SetExpressionChecker implements ExpressionChecker {
    private final Set<String> expressions;

    public SetExpressionChecker(Set<String> expressions) {
        this.expressions = expressions;
    }

    @Override
    public boolean isExpression(String exp) {
        final String trimmed = exp.trim();
        try {
            final Expression expression = Expression.parse(trimmed);
            return expressions.stream()
                    .map(Expression::parse)
                    .anyMatch(expression::equalsIgnoreCase);
        } catch (IllegalExpression e) {
            return false;
        }
    }
}
