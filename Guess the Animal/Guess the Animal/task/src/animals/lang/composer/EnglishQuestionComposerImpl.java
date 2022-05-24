package animals.lang.composer;

import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.FactType;
import animals.i18n.GrammarKeys;
import animals.lang.Token;
import animals.util.MapBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static animals.lang.composer.Util.questionize;
import static animals.lang.composer.Util.resSupplier;

class EnglishQuestionComposerImpl implements Composer {
    private final Map<FactType, Supplier<String>> questionPatterns =
            MapBuilder.<FactType, Supplier<String>>immutable()
                    .put(FactType.HAS, resSupplier(GrammarKeys.HAS_Q))
                    .put(FactType.IS, resSupplier(GrammarKeys.IS_Q))
                    .put(FactType.CAN, resSupplier(GrammarKeys.CAN_Q))
                    .build();

    @Override
    public Expression get(Fact fact) {
        Expression expression = fact.exp();
        if (questionPatterns.containsKey(fact.type())) {
            String questionPrefix = questionPatterns.get(fact.type()).get();
            List<Token> tokens = new ArrayList<>(Expression.parse(questionPrefix).tokens());
            List<Token> expTokens = expression.tokens();
            tokens.addAll(expTokens.subList(2, expTokens.size() - 1));
            final Token lastWord = expTokens.get(expTokens.size() - 1);
            tokens.add(questionize(lastWord));
            return Expression.fromTokens(tokens);
        }
        throw new IllegalStateException();
    }

}
