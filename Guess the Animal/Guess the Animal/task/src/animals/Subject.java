package animals;

import java.util.List;
import java.util.stream.Collectors;

public class Subject implements Expression {
    public boolean hasArticle() {
        return hasArticle;
    }

    private final ArticleType articleType;
    private final List<Token> word;
    private final boolean hasArticle;

    public Subject(Expression e) {
        ArticleType type = ArticleType.fromToken(e.first());
        this.hasArticle = type != ArticleType.NONE;
        this.articleType = hasArticle ? type : ArticleType.forExpression(e);
        this.word = e.tokens();
    }

    @Override
    public List<Token> tokens() {
        return word;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public String asText() {
        Expression expression = withoutArticle();
        ArticleType type = hasArticle ? articleType : ArticleType.forExpression(expression);
        return type.content() + " " + expression.asText();
    }

    public Expression withoutArticle() {
        return ExpressionImpl.create(tokens().stream()
                .skip(hasArticle ? 1 : 0)
                .collect(Collectors.toList()));
    }
}
