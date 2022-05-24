package animals.lang.composer;

import animals.lang.Expression;
import animals.lang.Fact;
import animals.i18n.GrammarKeys;
import animals.lang.Token;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static animals.i18n.ResourceBundles.GRAMMAR;

class EsperantoQuestionComposerImpl implements Composer {
    private static final int MIN_FACT_WORDS_SIZE = 2;

    @Override
    public Expression get(Fact fact) {
        String questionPrefix = new MessageFormat(GRAMMAR.getString(GrammarKeys.QUESTION_PATTERN))
                .format(new Object[] {GRAMMAR.getString(GrammarKeys.IT), verb(fact).content()});
        List<Token> tokens = new ArrayList<>(Expression.parse(questionPrefix).tokens());
        List<Token> expTokens = fact.exp().tokens();
        tokens.addAll(expTokens.subList(2, expTokens.size() - 1));
        final Token lastWord = expTokens.get(expTokens.size() - 1);
        tokens.add(Util.questionize(lastWord));
        return Expression.fromTokens(tokens);
    }

    private static Token verb(Fact fact) {
        List<Token> tokens = fact.exp().tokens();
        if (tokens.size() < MIN_FACT_WORDS_SIZE) {
            throw new IllegalStateException("Fact should contain at least two word");
        }
        return tokens.get(1);
    }
}
