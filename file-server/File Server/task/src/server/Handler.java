package server;

@FunctionalInterface
public interface Handler<T, S> {
  void handle(final T response, final Session<S, T> session);
}
