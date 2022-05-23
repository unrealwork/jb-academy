package animals.lang;

import java.util.ListResourceBundle;

import static animals.lang.GrammarKeys.CAN;
import static animals.lang.GrammarKeys.CAN_NEGATIVE;
import static animals.lang.GrammarKeys.CAN_Q;
import static animals.lang.GrammarKeys.DEFINITE_ARTICLE;
import static animals.lang.GrammarKeys.HAS;
import static animals.lang.GrammarKeys.HAS_NEGATIVE;
import static animals.lang.GrammarKeys.HAS_Q;
import static animals.lang.GrammarKeys.HAS_UNDEFINITE;
import static animals.lang.GrammarKeys.IS;
import static animals.lang.GrammarKeys.IS_NEGATIVE;
import static animals.lang.GrammarKeys.IS_Q;
import static animals.lang.GrammarKeys.IT;
import static animals.lang.GrammarKeys.UNDEFINITE_A;
import static animals.lang.GrammarKeys.UNDEFINITE_AN;

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
                {IS_NEGATIVE, "ne estas"},
                {IS_Q, "Ĉu ĝi estas"},
                {HAS_NEGATIVE, "ne havas"},
                {HAS_Q, "Ĉu ĝi havas"},
                {CAN_NEGATIVE, "ne povas"},
                {CAN_Q, "Ĉu ĝi povas"},
                {HAS_UNDEFINITE, Boolean.FALSE}
        };
    }
}
