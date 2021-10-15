package common;

public class DeleteRequest implements Request {
  private final String path;

  public DeleteRequest(String path) {
    this.path = path;
  }

  @Override
  public ReqType type() {
    return ReqType.DELETE;
  }

  @Override
  public String path() {
    return path;
  }

  @Override
  public String toMessage() {
    return type() + " " + path();
  }
}
