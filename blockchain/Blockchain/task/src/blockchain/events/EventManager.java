package blockchain.events;


public interface EventManager<T> {
    void notify(T data);

    void subscribe(EventListener<T> listener);

    void unsubscribe(EventListener<T> listener);
}
