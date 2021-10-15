package client;

import common.ReqType;
import common.Request;

public class ExitRequest implements Request {
  @Override
  public ReqType type() {
    return ReqType.EXIT;
  }

  @Override
  public String path() {
    return "";
  }

  @Override
  public String toMessage() {
    return type().toString();
  }
}
