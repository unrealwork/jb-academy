package common;

public class GetRequest implements Request {
  private final String path;

  public GetRequest(String path) {
    this.path = path;
  }

  @Override
  public ReqType type() {
    return ReqType.GET;
  }

  @Override
  public String path() {
    return path;
  }

  @Override
  public String toMessage() {
    return type().toString() + " " + path;
  }
}
