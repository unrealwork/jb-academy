package blockchain.events;

import java.util.LinkedHashSet;
import java.util.Set;

public class BasicEventManager<T> implements EventManager<T> {
    private final Set<EventListener<T>> listeners;

    private BasicEventManager() {
        listeners = new LinkedHashSet<>();
    }

    public static <T> EventManager<T> create() {
        return new BasicEventManager<>();
    }

    @Override
    public void notify(T data) {
        listeners.forEach(listener -> listener.handle(data));
    }

    @Override
    public void subscribe(EventListener<T> listener) {
        listeners.add(listener);
    }

    @Override
    public void unsubscribe(EventListener<T> listener) {
        listeners.remove(listener);
    }
}
