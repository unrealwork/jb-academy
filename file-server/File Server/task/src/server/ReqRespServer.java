package server;

import common.Request;
import common.Response;

import java.io.IOException;

public class ReqRespServer implements Server<Response, Request>, AutoCloseable {
  private final MessageServer messageServer;

  public ReqRespServer(MessageServer messageServer) {
    this.messageServer = messageServer;
  }

  @Override
  public void start() throws Exception {
    messageServer.start();
  }

  @Override
  public void listen() throws Exception {
    messageServer.listen();
  }

  @Override
  public void send(Response message) throws IOException {
    messageServer.send(message.asMessage());
  }

  @Override
  public void stop() {
    messageServer.stop();
  }

  @Override
  public void addMessageCallback(Handler<Request, Response> callback) {
    messageServer.addMessageCallback(
        (req, session) -> callback.handle(Request.parse(req), ReqRespSession.with(session)));
  }

  @Override
  public void close() throws Exception {
    messageServer.close();
  }

  private static class ReqRespSession implements Session<Response, Request> {
    private final Session<String, String> session;

    private ReqRespSession(Session<String, String> messageSession) {
      this.session = messageSession;
    }

    private static ReqRespSession with(Session<String, String> messageSession) {
      return new ReqRespSession(messageSession);
    }

    @Override
    public void sendMessage(Response message) throws IOException {
      session.sendMessage(message.asMessage());
    }

    @Override
    public Request receiveMessage() throws IOException {
      return Request.parse(session.receiveMessage());
    }
  }
}
