package animals;

import java.util.List;
import java.util.stream.Collectors;

public class FactImpl implements Fact {
    private final Expression expression;
    private final FactType type;

    public FactImpl(Expression expression, FactType type) {
        this.expression = expression;
        this.type = type;
    }

    public Expression factExpression() {
        List<Token> tokens = expression.tokens().stream()
                .skip(2)
                .collect(Collectors.toList());
        return new ExpressionImpl(tokens);
    }

    @Override
    public FactType type() {
        return type;
    }

    @Override
    public Expression exp() {
        return expression;
    }
}
