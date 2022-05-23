package animals.lang;

import java.util.ListResourceBundle;
import java.util.Locale;

import static animals.lang.GrammarKeys.*;

public class Grammar extends ListResourceBundle {



    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {DEFINITE_ARTICLE, "the"},
                {UNDEFINITE_AN, "an"},
                {UNDEFINITE_A, "a"},
                {IT, "it"},
                {IS, "is"},
                {CAN, "can"},
                {HAS, "has"},
                {IS_NEGATIVE, "isn't"},
                {IS_Q, "Is it"},
                {HAS_NEGATIVE, "doesn't have"},
                {HAS_Q, "Does it have"},
                {CAN_NEGATIVE, "can't"},
                {CAN_Q, "Can it"},
                {HAS_UNDEFINITE, Boolean.TRUE}
        };
    }
}
