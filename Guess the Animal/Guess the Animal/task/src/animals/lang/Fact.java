package animals.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static animals.util.ResourceBundles.grammar;

public interface Fact {
    static Fact fromExpression(Expression expression) throws IllegalExpressionException {
        List<Token> tokenList = expression.tokens();
        if (tokenList.size() < 3) {
            throw new IllegalExpressionException("Too short fact");
        }
        final FactType type = FactType.fromToken(tokenList.get(1));
        return new FactImpl(expression, type);
    }

    static Fact fromSubject(Subject subject) {
        Expression exp = subject.withoutArticle();
        List<Token> subTokens = exp.tokens();
        List<Token> factTokens = new ArrayList<>(2 + subTokens.size());
        factTokens.add(Token.word(grammar(GrammarKeys.IT)));
        factTokens.add(Token.word(FactType.IS.content()));
        String article = ArticleType.forExpression(exp).content();
        if (article != null) {
            factTokens.add(Token.word(article));
        }
        factTokens.addAll(subTokens);
        return Fact.fromExpression(Expression.fromTokens(factTokens));
    }

    FactType type();

    Expression exp();

    Expression exp(final boolean capitalizeFirst);

    Expression about(Subject s, final boolean isTrue);

    Expression aboutIt(boolean isTrue);

    Expression question();

}
