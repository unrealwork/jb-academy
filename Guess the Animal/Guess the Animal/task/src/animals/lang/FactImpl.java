package animals.lang;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static animals.lang.ArticleType.THE;
import static animals.util.ResourceBundles.grammar;

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

    @Override
    public Expression about(Subject s, boolean isTrue) {
        final List<Token> tokenList = new ArrayList<>();
        String article = capitalizeFirstLetter(THE.content());
        tokenList.add(Token.word(article));
        tokenList.addAll(s.withoutArticle().toLowerCase().tokens());
        tokenList.add(Token.word(isTrue ? type.content() : type.negation()));
        List<Token> expTokens = expression.tokens();
        tokenList.addAll(expTokens.subList(2, expTokens.size()));
        return Expression.fromTokens(tokenList);
    }

    @Override
    public Expression aboutIt(boolean isTrue) {
        final List<Token> tokenList = new ArrayList<>();
        tokenList.add(Token.word(grammar(GrammarKeys.IT)));
        tokenList.add(Token.word(isTrue ? type.content() : type.negation()));
        List<Token> expTokens = expression.tokens();
        tokenList.addAll(expTokens.subList(2, expTokens.size()));
        return Expression.fromTokens(tokenList);
    }


    @Override
    public Expression question() {
        List<Token> tokens = new ArrayList<>(Expression.parse(type.question()).tokens());
        List<Token> expTokens = expression.tokens();
        tokens.addAll(expTokens.subList(2, expTokens.size() - 1));
        final Token lastWord = expTokens.get(expTokens.size() - 1);
        tokens.add(questionize(lastWord));
        return Expression.fromTokens(tokens);
    }

    private Token questionize(Token lastWord) {
        return lastWord.content().endsWith("?") ? Token.word(lastWord.content()) : Token.word(lastWord.content() + "?");
    }


    private String capitalizeFirstLetter(final String s) {
        if (null == s) {
            throw new IllegalStateException();
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
