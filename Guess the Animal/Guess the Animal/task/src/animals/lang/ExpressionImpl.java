package animals.lang;

import java.util.List;
import java.util.Objects;

class ExpressionImpl implements Expression {
    private final List<Token> words;

    private ExpressionImpl(List<Token> words) {
        this.words = words;
    }

    public static ExpressionImpl create(List<Token> words) {
        return new ExpressionImpl(words);
    }

    @Override
    public List<Token> tokens() {
        return words;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExpressionImpl that = (ExpressionImpl) o;
        return Objects.equals(words, that.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }
}
