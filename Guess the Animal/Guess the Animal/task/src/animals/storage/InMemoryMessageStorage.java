package animals.storage;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import static animals.util.ResourceBundles.msg;


public class InMemoryMessageStorage implements MessageStorage {
    private final Map<String, Set<String>> storage;
    private final ResourceBundle bundle = msg();

    public InMemoryMessageStorage(Map<String, Set<String>> storage) {
        this.storage = storage;
    }

    @Override
    public Set<String> get(String messageKey) {
        if (bundle.containsKey(messageKey)) {
            return Set.of(bundle.getStringArray(messageKey));
        }
        return storage.get(messageKey);
    }

    @Override
    public String find(String messageKey) {
        if (bundle.containsKey(messageKey)) {
            return bundle.getString(messageKey);
        }
        return storage.getOrDefault(messageKey, Collections.emptySet())
                .iterator()
                .next();
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
