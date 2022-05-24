package animals.lang;


import java.util.ArrayList;
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
        return ExpressionImpl.create(tokens);
    }

    @Override
    public FactType type() {
        return type;
    }

    @Override
    public Expression exp() {
        return expression;
    }

    @Override
    public Expression exp(boolean capitalizeFirst) {
        if (capitalizeFirst) {
            Expression exp = exp();
            List<Token> newTokens = new ArrayList<>();
            newTokens.add(Token.word(capitalizeFirstLetter(exp.first().content())));
            List<Token> tokens = exp.tokens();
            newTokens.addAll(tokens.subList(1, tokens.size()));
            return Expression.fromTokens(newTokens);
        }
        return expression;
    }
    
    private String capitalizeFirstLetter(final String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
