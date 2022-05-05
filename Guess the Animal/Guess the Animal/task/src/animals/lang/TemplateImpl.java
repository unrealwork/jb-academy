package animals.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateImpl implements Template {
    private final String templateText;
    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{}");

    public TemplateImpl(String templateText) {
        this.templateText = templateText;
    }

    @Override
    public String format(Object... objs) {
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(templateText);
        int i = 0;
        String res = templateText;
        int shift = 0;
        while (matcher.find() && i < objs.length) {
            String value = objs[i].toString();
            res = res.substring(0, matcher.start() + shift) + value + res.substring(matcher.end() + shift);
            shift += (value.length() - (matcher.end() - matcher.start()));
            i++;
        }

        return res;
    }
}
