package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class MessageSession implements Runnable, AutoCloseable, Session<String, String> {
  private final Handler<String, String> messageCallback;
  private final AtomicBoolean isOpened = new AtomicBoolean();
  private final Socket socket;
  private DataInputStream is;
  private DataOutputStream os;

  public MessageSession(Socket socket, Handler<String, String> messageCallback) {
    this.socket = socket;
    this.messageCallback = messageCallback;
  }

  @Override
  public void run() {
    try {

      if (socket.isConnected()) {
        this.os = new DataOutputStream(this.socket.getOutputStream());
        this.is = new DataInputStream(socket.getInputStream());
        isOpened.set(true);
      }
      while (isOpened.get()) {
        final String message = receiveMessage();
        if (message != null) {
          messageCallback.handle(message, this);
        }
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public void sendMessage(final String message) throws IOException {
    this.os.writeUTF(message);
  }

  @Override
  public String receiveMessage() throws IOException {
    try {
      return this.is.readUTF();
    } catch (IOException e) {
      return null;
    }
  }

  @Override
  public InputStream is() {
    return this.is;
  }

  @Override
  public void close() throws Exception {
    isOpened.set(false);
    if (this.socket != null && !this.socket.isClosed()) {
      this.socket.close();
    }
  }
}
