package animals;

import java.util.Arrays;
import java.util.List;

public interface Fact {
    static Fact fromExpression(Expression expression) throws IllegalExpression {
        List<Token> tokenList = expression.tokens();
        if (tokenList.size() < 3) {
            throw new IllegalExpression("Too short fact");
        }
        if (!tokenList.get(0).content().equalsIgnoreCase("it")) {
            throw new IllegalExpression("Fact should start with 'it'");
        }
        final FactType type = FactType.fromToken(tokenList.get(1));
        if (type == null) {
            throw new IllegalExpression("Invalid fact verb. Should be one of " + Arrays.toString(FactType.values()));
        }
        return new FactImpl(expression, type);
    }

    FactType type();

    Expression exp();

    Expression about(Subject s, final boolean isTrue);

    Expression question();

}
