package animals.lang.composer;

import animals.lang.Expression;
import animals.lang.Fact;
import animals.i18n.GrammarKeys;
import animals.lang.Subject;
import animals.lang.Token;

import java.util.ArrayList;
import java.util.List;

import static animals.lang.composer.Util.addSubject;
import static animals.i18n.ResourceBundles.GRAMMAR;

public class EsperantoAssertionComposerImpl implements Composer {
    private final boolean isPositive;
    private final Subject s;

    private EsperantoAssertionComposerImpl(boolean isPositive, Subject s) {
        this.isPositive = isPositive;
        this.s = s;
    }

    static EsperantoAssertionComposerImpl create(boolean isPositive, Subject s) {
        return new EsperantoAssertionComposerImpl(isPositive, s);
    }

    @Override
    public Expression get(Fact fact) {
        final List<Token> tokenList = new ArrayList<>();
        addSubject(tokenList,s);
        Token verb = fact.exp().tokens().get(1);
        if (!isPositive) {
            tokenList.add(Token.word(GRAMMAR.getString(GrammarKeys.NEGATION)));
        }
        tokenList.add(verb);
        List<Token> expTokens = fact.exp().tokens();
        tokenList.addAll(expTokens.subList(2, expTokens.size()));
        return Expression.fromTokens(tokenList);
    }

    
}
