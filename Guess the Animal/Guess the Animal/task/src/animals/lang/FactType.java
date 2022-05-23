package animals.lang;

import static animals.lang.GrammarKeys.CAN_NEGATIVE;
import static animals.lang.GrammarKeys.CAN_Q;
import static animals.lang.GrammarKeys.HAS_NEGATIVE;
import static animals.lang.GrammarKeys.HAS_Q;
import static animals.lang.GrammarKeys.IS_NEGATIVE;
import static animals.lang.GrammarKeys.IS_Q;
import static animals.util.ResourceBundles.grammar;

public enum FactType {
    IS(GrammarKeys.IS, IS_NEGATIVE, IS_Q),
    HAS(GrammarKeys.HAS, HAS_NEGATIVE, HAS_Q),
    CAN(GrammarKeys.CAN, CAN_NEGATIVE, CAN_Q);

    private final String assertionKey;
    private final String negationKey;
    private final String questionKey;


    FactType(String assertionKey, String negativeKey, String questionKey) {
        this.assertionKey = assertionKey;
        this.negationKey = negativeKey;
        this.questionKey = questionKey;
    }

    public String negation() {
        return grammar(negationKey);
    }

    public String question() {
        return grammar(questionKey);
    }

    public String content() {
        return grammar(assertionKey);
    }

    public static FactType fromToken(Token token) {
        for (FactType value : values()) {
            if (value.content().equalsIgnoreCase(token.content())) {
                return value;
            }
        }
        return null;
    }
}
