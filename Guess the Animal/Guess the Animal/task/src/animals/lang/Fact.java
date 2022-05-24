package animals.lang;

import animals.i18n.GrammarKeys;

import java.util.ArrayList;
import java.util.List;

import static animals.i18n.ResourceBundles.GRAMMAR;


public interface Fact {

    int MIN_FACT_WORDS_AMOUNT = 3;

    static Fact fromExpression(Expression expression) throws IllegalExpressionException {
        List<Token> tokenList = expression.tokens();
        if (tokenList.size() < MIN_FACT_WORDS_AMOUNT) {
            throw new IllegalExpressionException("Too short fact");
        }
        final FactType type = FactType.fromToken(tokenList.get(1));
        return new FactImpl(expression, type);
    }

    static Fact fromSubject(Subject subject) {
        Expression exp = subject.withoutArticle();
        List<Token> subTokens = exp.tokens();
        List<Token> factTokens = new ArrayList<>(2 + subTokens.size());
        factTokens.add(Token.word(GRAMMAR.getString(GrammarKeys.IT)));
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
}
