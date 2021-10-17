package server;

import java.io.IOException;
import java.io.InputStream;

public interface Server<T, S> {
  void start() throws Exception;

  void listen() throws Exception;

  void send(T message) throws IOException;
  
  void stop();

  void addMessageCallback(Handler<S, T> callback);
  
}
