package animals;

import java.util.HashMap;
import java.util.Set;

class DefaultMessageStorage extends MessageStorageDecorator {
    public DefaultMessageStorage() {
        super(storage());
    }

    private static MessageStorage storage() {
        HashMap<String, Set<String>> storage = new HashMap<>();
        storage.put("greeting_morning", Set.of(
                "Good morning!"
        ));
        storage.put("greeting_afternoon", Set.of(
                "Good afternoon!"
        ));

        storage.put("greeting_evening", Set.of(
                "Good evening!"
        ));
        return new InMemoryMessageStorage(storage);
    }
}
