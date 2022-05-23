package animals.util;

import java.util.ResourceBundle;

public final class ResourceBundles {

    public static final ResourceBundle GRAMMAR = ResourceBundle.getBundle("animals.lang.Grammar");
    public static final ResourceBundle MSG = ResourceBundle.getBundle("animals.storage.Messages");

    private ResourceBundles() {

    }

    public static ResourceBundle grammar() {
        return GRAMMAR;
    }

    public static String grammar(String key) {
        return GRAMMAR.getString(key);
    }

    public static ResourceBundle msg() {
        return MSG;
    }

}
