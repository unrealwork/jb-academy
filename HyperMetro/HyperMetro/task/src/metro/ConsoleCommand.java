package metro;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleCommand {
    private static final Pattern NAME_PATTERN = Pattern.compile("/(\\w+)");
    private static final Pattern ARG_PATTERN = Pattern.compile("\\s*(\"(.+)\"|(\\S+))\\s*");

    public List<String> getArgs() {
        return args;
    }

    private final String type;
    private final List<String> args;

    private ConsoleCommand(String type, List<String> args) {
        this.type = type;
        this.args = args;
    }

    public static ConsoleCommand parse(String cmd) {
        final Matcher nameMatcher = NAME_PATTERN.matcher(cmd);
        final String cmdName;
        final String argsPart;
        if (nameMatcher.find() && nameMatcher.start() == 0) {
            cmdName = nameMatcher.group(1);
            argsPart = cmd.substring(nameMatcher.end());
        } else {
            throw new IllegalStateException("Incorrect format of command. Command: " + cmd);
        }
        Matcher argMatcher = ARG_PATTERN.matcher(argsPart);
        List<String> args = new ArrayList<>();
        while (argMatcher.find()) {
            String group = argMatcher.group(2);
            final String value = group == null? argMatcher.group(3) : group;
            args.add(value);
        }
        return new ConsoleCommand(cmdName, Collections.unmodifiableList(args));
    }

    public String getType() {
        return type;
    }
}
