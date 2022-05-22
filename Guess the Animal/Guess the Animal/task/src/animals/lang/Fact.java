package animals.lang;

import java.util.Arrays;
import java.util.List;

public interface Fact {
    static Fact fromExpression(Expression expression) throws IllegalExpressionException {
        List<Token> tokenList = expression.tokens();
        if (tokenList.size() < 3) {
            throw new IllegalExpressionException("Too short fact");
        }
        if (!"it".equalsIgnoreCase(tokenList.get(0).content())) {
            throw new IllegalExpressionException("Fact should start with 'it'");
        }
        final FactType type = FactType.fromToken(tokenList.get(1));
        if (type == null) {
            throw new IllegalExpressionException("Invalid fact verb. Should be one of " + Arrays.toString(FactType.values()));
        }
        return new FactImpl(expression, type);
    }

    static Fact fromSubject(Subject subject) {
        return Fact.fromExpression(Expression.parse("It is " + subject.asText()));
    }
    FactType type();

    Expression exp();
    
    Expression exp(final boolean capitalizeFirst);

    Expression about(Subject s, final boolean isTrue);

    Expression aboutIt(boolean isTrue);

    Expression question();

}
