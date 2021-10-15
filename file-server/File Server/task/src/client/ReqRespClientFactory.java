package client;

import java.io.IOException;

public class ReqRespClientFactory {
  private static final String DEFAULT_HOST = "127.0.0.1";
  private static final int DEFAULT_PORT = 23456;

  private ReqRespClientFactory() {}

  public static ReqRespClient connect(final String host, final int port) throws IOException {
    return new SocketReqRespClient(SocketMessageClient.connect(host, port));
  }

  public static ReqRespClient defaultClient() {
    try {
      return connect(DEFAULT_HOST, DEFAULT_PORT);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to connect to default server", e);
    }
  }
}
