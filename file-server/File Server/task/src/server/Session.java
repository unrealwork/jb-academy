package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class Session implements Runnable, AutoCloseable {
  private final Consumer<String> messageCallback;
  private final AtomicBoolean isOpened = new AtomicBoolean();
  private Socket socket;
  private DataInputStream is;
  private DataOutputStream os;

  public Session(Socket socket, Consumer<String> messageCallback) {
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
          messageCallback.accept(message);
        }
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    } 
  }

  public void sendMessage(final String message) throws IOException {
    this.os.writeUTF(message);
  }

  public String receiveMessage() throws IOException {
    return this.is.readUTF();
  }

  @Override
  public void close() throws Exception {
    isOpened.set(false);
    if (this.socket != null && !this.socket.isClosed()) {
      this.socket.close();
    }
  }
}
