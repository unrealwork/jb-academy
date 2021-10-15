package client;

import common.Request;
import common.Response;

import java.io.IOException;

public interface ReqRespClient extends Receiver<Response>, Sender<Request>, AutoCloseable {
  default Response request(Request request) throws IOException {
    send(request);
    return receive();
  }
}
