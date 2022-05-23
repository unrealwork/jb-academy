package animals.storage;

import java.util.Collections;

class DefaultMessageStorage extends MessageStorageDecorator {


    public DefaultMessageStorage() {
        super(storage());
    }

    private static MessageStorage storage() {
        return new InMemoryMessageStorage(Collections.emptyMap());
    }
}
