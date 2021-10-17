package common;

import client.ExitRequest;

import java.io.InputStream;
import java.util.Scanner;

public interface Request {
  static Request read(InputStream is) {
    Scanner scanner = new Scanner(is);
    final ReqType type = ReqType.valueOf(scanner.next());
    switch (type) {
      case GET:
        return new GetRequest(scanner.next());
      case PUT:
        return new PutRequest(scanner.next(), is);
      case DELETE:
        return new DeleteRequest(scanner.next());
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
