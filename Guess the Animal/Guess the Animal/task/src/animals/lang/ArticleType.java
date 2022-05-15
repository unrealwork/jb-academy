package animals.lang;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum ArticleType {
    THE(true, "the"), AN("an"), A("a"), NONE(null);
    private final boolean isDefinite;
    private final String content;

    ArticleType(boolean isDefinite, String content) {
        this.isDefinite = isDefinite;
        this.content = content;
    }

    ArticleType(String content) {
        this.content = content;
        this.isDefinite = false;
    }

    public String content() {
        return content;
    }

    public boolean isDefinite() {
        return isDefinite;
    }


    public static ArticleType fromToken(Token s) {
        for (ArticleType art : values()) {
            if (s.content().equalsIgnoreCase(art.content)) {
                return art;
            }
        }
        return NONE;
    }

    public static ArticleType forExpression(Expression expression) {
        Token first = expression.first();
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
}
