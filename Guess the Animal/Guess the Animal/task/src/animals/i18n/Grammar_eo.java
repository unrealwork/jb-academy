package animals.i18n;

import java.util.ListResourceBundle;

import static animals.i18n.GrammarKeys.CAN;
import static animals.i18n.GrammarKeys.DEFINITE_ARTICLE;
import static animals.i18n.GrammarKeys.HAS;
import static animals.i18n.GrammarKeys.HAS_UNDEFINITE;
import static animals.i18n.GrammarKeys.IS;
import static animals.i18n.GrammarKeys.IT;
import static animals.i18n.GrammarKeys.NEGATION;
import static animals.i18n.GrammarKeys.QUESTION_PATTERN;

@SuppressWarnings("squid:S101")
public class Grammar_eo extends ListResourceBundle {


    @Override
    public String getBaseBundleName() {
        return null;
    }

    public Grammar_eo() {
        super();
        setParent(null);

    }

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {DEFINITE_ARTICLE, "la"},
                {IT, "Ĝi"},
                {IS, "estas"},
                {CAN, "povas"},
                {HAS, "havas"},
                {HAS_UNDEFINITE, Boolean.FALSE},
                {QUESTION_PATTERN, "Ĉu {0} {1}"},
                {NEGATION, "ne"}
        };
    }
}
