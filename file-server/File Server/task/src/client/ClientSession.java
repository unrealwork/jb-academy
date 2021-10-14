package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class ClientSession implements Runnable, AutoCloseable {
  private Socket socket;
  private DataInputStream is;
  private DataOutputStream os;

  public ClientSession(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      if (socket.isConnected()) {
        this.is = new DataInputStream(this.socket.getInputStream());
        this.os = new DataOutputStream(this.socket.getOutputStream());
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  public void sendMessage(final String message) throws IOException {
    this.os.writeUTF(message);
  }

  public String receiveMessage() throws IOException {
    final String message = this.is.readUTF();
    return message;
  }

  @Override
  public void close() throws Exception {
    if (this.is != null) {
      this.is.close();
    }
    if (this.os != null) {
      this.os.close();
    }
    if (this.socket != null) {
      this.socket.close();
    }
  }
}
