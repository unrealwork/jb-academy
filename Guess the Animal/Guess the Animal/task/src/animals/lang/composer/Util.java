package animals.lang.composer;

import animals.i18n.GrammarKeys;
import animals.lang.Subject;
import animals.lang.Token;

import java.util.List;
import java.util.function.Supplier;

import static animals.lang.ArticleType.THE;
import static animals.i18n.ResourceBundles.GRAMMAR;

final class Util {
    private Util() {

    }

    static Supplier<String> resSupplier(String resourceKey) {
        return () -> GRAMMAR.getString(resourceKey);
    }

    static Token questionize(Token lastWord) {
        return lastWord.content().endsWith("?") ? Token.word(lastWord.content()) : Token.word(lastWord.content() + "?");
    }

    static String capitalizeFirstLetter(final String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    static void addSubject(List<Token> tokenList, Subject s) {
        if (s != null) {
            String article = THE.content();
            if (article != null) {
                tokenList.add(Token.word(capitalizeFirstLetter(article)));
            }
            tokenList.addAll(s.withoutArticle().toLowerCase().tokens());
        } else {
            String it = capitalizeFirstLetter(GRAMMAR.getString(GrammarKeys.IT));
            tokenList.add(Token.word(it));
        }
    }
}
