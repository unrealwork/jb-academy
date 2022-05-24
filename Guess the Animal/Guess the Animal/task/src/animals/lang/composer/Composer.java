package animals.lang.composer;

import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.Subject;

import java.util.Locale;

public interface Composer {

    /**
     * Compose an expression from {@link Fact} questions, assertions etc.
     *
     * @param fact fact about something.
     * @return composed expression.
     */
    Expression get(Fact fact);
    
    static Expression question(Fact fact) {
        return questionComposer().get(fact);
    }

    static Expression about(Fact fact, Subject s, boolean isPositive) {
        return aboutComposer(s, isPositive).get(fact);
    }

    static Expression aboutIt(Fact fact, boolean isPositive) {
        return aboutComposer(null, isPositive).get(fact);
    }

    private static Composer questionComposer() {
        String language = Locale.getDefault().getLanguage();
        switch (language) {
            case "en":
                return new EnglishQuestionComposerImpl();
            case "eo":
                return new EsperantoQuestionComposerImpl();
            default:
                throw new IllegalStateException("Unsupported language to compose question");
        }
    }

    private static Composer aboutComposer(Subject s, boolean isPositive) {
        String language = Locale.getDefault().getLanguage();
        switch (language) {
            case "en":
                return EnglishAssertionComposerImpl.create(isPositive, s);
            case "eo":
                return EsperantoAssertionComposerImpl.create(isPositive, s);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
