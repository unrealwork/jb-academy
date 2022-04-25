package animals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateImpl implements Template {
    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{}");

    @Override
    public String format(String template, Object... objs) {
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(template);
        int i = 0;
        String res = template;
        int shift = 0;
        while (matcher.find() && i < objs.length) {
            String value = objs[i].toString();
            res = res.substring(0, matcher.start() + shift) + value + res.substring(matcher.end() + shift);
            shift += (value.length() - (matcher.end() - matcher.start()));
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        String res = Template.create()
                .format("Specify a fact that distinguishes {} from {}.", "a cat", "a shark");
        System.out.println(res);
    }
}
