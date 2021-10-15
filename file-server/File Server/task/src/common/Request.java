package common;

public interface Request {
  ReqType type();

  String path();

  String toMessage();
}
