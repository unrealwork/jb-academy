package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class PlainMessageServer implements AutoCloseable, MessageServer {
  private static final String HOST = "127.0.0.1";
  private static final ExecutorService POOL =
      new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
  private final Collection<Handler<String, String>> messageCallbacks =
      new ConcurrentLinkedQueue<>();
  private final Collection<MessageSession> sessions = new HashSet<>();
  private final AtomicBoolean isListening = new AtomicBoolean();

  private PlainMessageServer() {}

  static PlainMessageServer socket() {
    return new PlainMessageServer();
  }

  @Override
  public void start() throws Exception {
    listen();
  }

  @Override
  public void listen() throws Exception {
    isListening.set(true);
    while (isListening.get()) {
      try {
        final MessageSession session =
            new MessageSession(
                serverSocket().accept(),
                (m, s) -> messageCallbacks.forEach(callback -> callback.handle(m, s)));
        PlainMessageServer.POOL.execute(session);
        sessions.add(session);
      } catch (SocketException e) {
        break;
      }
    }
  }

  @Override
  public void sendMessage(String message) throws IOException {
    for (MessageSession session : sessions) {
      session.sendMessage(message);
    }
  }

  @Override
  public void send(final String message) throws IOException {
    for (MessageSession s : sessions) {
      s.sendMessage(message);
    }
  }

  @Override
  public void stop() {
    this.isListening.set(false);
    Thread thread =
        new Thread(
            () -> {
              try {
                close();
              } catch (Exception e) {
                throw new IllegalStateException(e);
              }
            });
    thread.start();
  }

  @Override
  public void addMessageCallback(final Handler<String, String> callback) {
    messageCallbacks.add(callback);
  }

  private ServerSocket serverSocket() {
    return LazyHolder.SERVER_SOCKET;
  }

  @Override
  public void close() throws Exception {
    isListening.set(false);
    for (MessageSession session : sessions) {
      session.close();
    }
    if (!serverSocket().isClosed()) {
      serverSocket().close();
    }
    if (!POOL.isShutdown()) {
      POOL.shutdown();
    }
    final boolean isSucceed = POOL.awaitTermination(1, TimeUnit.MINUTES);
    if (!isSucceed) {
      throw new IllegalStateException("Failed to shutdown executor service");
    }
  }

  private static class LazyHolder {
    private static final int PORT = 23456;
    private static final ServerSocket SERVER_SOCKET = getServerSocket();

    private static ServerSocket getServerSocket() {
      try {
        return new ServerSocket(PORT, 50, InetAddress.getByName(HOST));
      } catch (IOException e) {
        throw new IllegalStateException(e);
      }
    }
  }
}
