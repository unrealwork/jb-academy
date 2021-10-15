package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SocketMessageClient implements AutoCloseable, MessageClient {
  private final ClientSession session;

  public SocketMessageClient(Socket socket) {
    this.session = new ClientSession(socket);
    session.run();
  }

  public static SocketMessageClient connect(final String host, final int port) throws IOException {
    Socket socket = new Socket(InetAddress.getByName(host), port);
    return new SocketMessageClient(socket);
  }

  @Override
  public void send(String message) throws IOException {
    session.send(message);
  }

  @Override
  public String receive() throws IOException {
    return session.receive();
  }

  @Override
  public void close() throws Exception {
    if (session != null) {
      session.close();
    }
  }
}
