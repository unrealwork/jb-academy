package animals.lang;

import animals.i18n.GrammarKeys;

import static animals.i18n.ResourceBundles.GRAMMAR;

public enum FactType {
    IS(GrammarKeys.IS),
    HAS(GrammarKeys.HAS),
    CAN(GrammarKeys.CAN);

    private final String assertionKey;


    FactType(String assertionKey) {
        this.assertionKey = assertionKey;
    }

    public String content() {
        return GRAMMAR.getString(assertionKey);
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
