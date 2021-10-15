package client;

import java.io.IOException;

public interface Sender<T> {
  void send(T t) throws IOException;
}
