package blockchain.events;

public interface EventListener<T> {
    void handle(T data);
}
