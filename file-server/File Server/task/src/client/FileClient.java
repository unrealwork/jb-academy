package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class FileClient implements AutoCloseable {
  private ClientSession session;

  public FileClient(Socket socket) {
    this.session = new ClientSession(socket);
    session.run();
  }

  public static FileClient connect(final String host, final int port) throws IOException {
    Socket socket = new Socket(InetAddress.getByName(host), port);
    return new FileClient(socket);
  }

  public void sendMessage(final String message) throws IOException {
    session.sendMessage(message);
  }

  public String recieveMessage() throws IOException {
    return session.receiveMessage();
  }

  @Override
  public void close() throws Exception {
    if (session != null) {
      session.close();
    }
  }
}
