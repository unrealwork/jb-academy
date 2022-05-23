package animals.storage;

import animals.lang.Template;

import java.text.MessageFormat;
import java.util.Set;

public interface MessageStorage {
    Set<String> get(String messageKey);

    String find(String messageKey);
    
    String template(String templateKey, Object... objects);
    
    MessageFormat template(String templateKey);
    
    static MessageStorage def() {
        return new DefaultMessageStorage();
    }
}
