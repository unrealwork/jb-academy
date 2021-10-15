package client;

import java.io.IOException;

public interface MessageSender extends Sender<String> {
  void send(String message) throws IOException;
}
