package client;

import common.Request;
import common.Response;

import java.io.IOException;

public class SocketReqRespClient implements ReqRespClient {
  private final MessageClient messageClient;

  public SocketReqRespClient(MessageClient messageClient) {
    this.messageClient = messageClient;
  }

  @Override
  public Response receive() throws IOException {
    return Response.parse(messageClient.receive());
  }

  @Override
  public void send(Request request) throws IOException {
    messageClient.send(request.toMessage());
  }

  @Override
  public void close() throws Exception {
    messageClient.close();
  }
}
