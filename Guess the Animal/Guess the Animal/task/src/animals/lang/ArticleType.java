package animals.lang;

import animals.i18n.GrammarKeys;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static animals.i18n.ResourceBundles.GRAMMAR;


public enum ArticleType {
    THE(true, GrammarKeys.DEFINITE_ARTICLE),
    AN(GrammarKeys.UNDEFINITE_AN),
    A(GrammarKeys.UNDEFINITE_A),
    NONE(null);
    private final boolean isDefinite;
    private final String contentKey;

    ArticleType(boolean isDefinite, String content) {
        this.isDefinite = isDefinite;
        this.contentKey = content;
    }

    ArticleType(String contentKey) {
        this.contentKey = contentKey;
        this.isDefinite = false;
    }

    public String content() {
        return isExist() && contentKey != null ? GRAMMAR.getString(contentKey) : null;
    }

    public boolean isDefinite() {
        return isDefinite;
    }


    public static ArticleType fromToken(Token s) {
        for (ArticleType art : values()) {
            if (art.isExist()) {
                String article = art.content();
                if (article != null && article.equalsIgnoreCase(s.content())) {
                    return art;
                }
            }
        }
        return NONE;
    }

    public static ArticleType forExpression(Expression expression) {
        Token first = expression.first();
        if (!hasIndefinite()) {
            return NONE;
        }
        if (first != null && first.length() > 0) {
            char c = first.content().charAt(0);
            if (Character.isAlphabetic(c)) {
                char lc = Character.toLowerCase(c);
                Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'e', 'i'));
                return vowels.contains(lc) ? AN : A;
            }
        }
        throw new IllegalStateException("Unable to define article");
    }

    private static boolean hasIndefinite() {
        return (Boolean) GRAMMAR.getObject(GrammarKeys.HAS_UNDEFINITE);
    }

    private boolean isExist() {
        if (this == NONE) {
            return true;
        }
        if (isDefinite()) {
            return true;
        }
        return hasIndefinite();
    }
}
