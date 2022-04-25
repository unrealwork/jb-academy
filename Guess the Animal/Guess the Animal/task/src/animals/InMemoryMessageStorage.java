package animals;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class InMemoryMessageStorage implements MessageStorage {
    private final Map<String, Set<String>> storage;

    public InMemoryMessageStorage(Map<String, Set<String>> storage) {
        this.storage = storage;
    }

    @Override
    public Set<String> get(String messageKey) {
        return storage.get(messageKey);
    }

    @Override
    public String find(String messageKey) {
        return storage.getOrDefault(messageKey, Collections.emptySet()).iterator().next();
    }

    @Override
    public String template(String templateKey, Object... objects) {
        return Template.create().format(find(templateKey), objects);
    }
}
