package client;

import common.Request;
import common.RespStatus;

import java.io.IOException;

public class SocketReqRespClient implements ReqRespClient {
  private final MessageClient messageClient;

  public SocketReqRespClient(MessageClient messageClient) {
    this.messageClient = messageClient;
  }

  @Override
  public RespStatus receive() throws IOException {
    return RespStatus.fromMessage(messageClient.receive());
  }

  @Override
  public void send(Request request) throws IOException {
    messageClient.send(request.toMessage());
  }

  @Override
  public void close() throws Exception {
    messageClient.close();
  }

  @Override
  public RespStatus request(Request request) throws IOException {
    send(request);
    return receive();
  }
}
