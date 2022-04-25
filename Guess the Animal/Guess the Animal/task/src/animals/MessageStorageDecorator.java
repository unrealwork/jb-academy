package animals;

import java.util.Set;

class MessageStorageDecorator implements MessageStorage {
    
    private final MessageStorage delegate;

    public MessageStorageDecorator(MessageStorage delegate) {
        this.delegate = delegate;
    }

    @Override
    public Set<String> get(String messageKey) {
        return delegate.get(messageKey);
    }

    @Override
    public String find(String messageKey) {
        return delegate.find(messageKey);
    }

    @Override
    public String template(String templateKey, Object... objects) {
        return delegate.template(templateKey, objects);
    }
}
