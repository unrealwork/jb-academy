package animals.storage;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Set;


public class InMemoryMessageStorage implements MessageStorage {
    private final ResourceBundle bundle;

    public InMemoryMessageStorage(ResourceBundle bundle) {
        this.bundle = bundle;
    }


    @Override
    public Set<String> get(String messageKey) {
        return Set.of(bundle.getStringArray(messageKey));
    }

    @Override
    public String find(String messageKey) {
        return bundle.getString(messageKey);
    }

    @Override
    public MessageFormat template(String templateKey) {
        return new MessageFormat(find(templateKey));
    }

    @Override
    public String template(String templateKey, Object... objects) {
        return MessageFormat.format(find(templateKey), objects);
    }
}
