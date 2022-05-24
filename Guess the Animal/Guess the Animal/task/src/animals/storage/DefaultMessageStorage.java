package animals.storage;

import animals.i18n.ResourceBundles;

class DefaultMessageStorage extends MessageStorageDecorator {


    public DefaultMessageStorage() {
        super(storage());
    }

    private static MessageStorage storage() {
        return new InMemoryMessageStorage(ResourceBundles.MSG);
    }
}
