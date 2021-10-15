package server;

import java.io.IOException;

public interface Session<T,S> {
  void sendMessage(T message) throws IOException;
  S receiveMessage() throws IOException;
}
