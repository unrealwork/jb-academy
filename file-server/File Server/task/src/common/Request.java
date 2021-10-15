package common;

import client.ExitRequest;

public interface Request {
  static Request parse(String req) {
    final String[] parts = req.split("\\s+", 3);
    final ReqType type = ReqType.valueOf(parts[0]);
    switch (type) {
      case GET:
        return new GetRequest(parts[1]);
      case PUT:
        return new PutRequest(parts[1], parts.length == 3 ? parts[2] : null);
      case DELETE:
        return new DeleteRequest(parts[1]);
      case EXIT:
        return new ExitRequest();
      default:
        throw new UnsupportedOperationException();
    }
  }

  ReqType type();
  String path();
  String toMessage();
}
