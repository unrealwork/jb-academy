package client;

import common.Request;
import common.RespStatus;

import java.io.IOException;

public interface ReqRespClient extends Receiver<RespStatus>, Sender<Request>, AutoCloseable {
  RespStatus request(Request request) throws IOException;
}
