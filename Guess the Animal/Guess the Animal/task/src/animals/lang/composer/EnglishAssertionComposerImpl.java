package animals.lang.composer;

import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.FactType;
import animals.i18n.GrammarKeys;
import animals.lang.Subject;
import animals.lang.Token;
import animals.util.MapBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static animals.lang.composer.Util.addSubject;
import static animals.lang.composer.Util.resSupplier;

class EnglishAssertionComposerImpl implements Composer {
    private final Map<FactType, Supplier<String>> negationPatterns =
            MapBuilder.<FactType, Supplier<String>>immutable()
                    .put(FactType.HAS, resSupplier(GrammarKeys.HAS_NEGATIVE))
                    .put(FactType.IS, resSupplier(GrammarKeys.IS_NEGATIVE))
                    .put(FactType.CAN, resSupplier(GrammarKeys.CAN_NEGATIVE))
                    .build();

    private final boolean isPositive;
    private final Subject s;

    private EnglishAssertionComposerImpl(boolean isPositive, Subject s) {
        this.isPositive = isPositive;
        this.s = s;
    }

    static EnglishAssertionComposerImpl create(boolean isPositive, Subject s) {
        return new EnglishAssertionComposerImpl(isPositive, s);
    }

    @Override
    public Expression get(Fact fact) {
        final List<Token> tokenList = new ArrayList<>();
        final FactType type = fact.type();
        addSubject(tokenList, s);
        tokenList.add(Token.word(isPositive ? type.content() : negation(fact)));
        List<Token> expTokens = fact.exp().tokens();
        tokenList.addAll(expTokens.subList(2, expTokens.size()));
        return Expression.fromTokens(tokenList);
    }

    private String negation(Fact fact) {
        if (negationPatterns.containsKey(fact.type())) {
            return negationPatterns.get(fact.type()).get();
        }
        throw new UnsupportedOperationException();
    }
}
