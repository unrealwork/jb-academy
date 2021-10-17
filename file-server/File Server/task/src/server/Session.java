package server;

import java.io.IOException;
import java.io.InputStream;

public interface Session<T,S> {
  void sendMessage(T message) throws IOException;
  S receiveMessage() throws IOException;
  InputStream is();
}
