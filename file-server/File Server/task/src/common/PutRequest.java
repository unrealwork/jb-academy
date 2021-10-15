package common;

public class PutRequest implements Request, Bodied {
  private final String body;

  public PutRequest(String body) {
    this.body = body;
  }

  @Override
  public ReqType type() {
    return ReqType.PUT;
  }

  @Override
  public String path() {
    return null;
  }

  @Override
  public String toMessage() {
    return null;
  }

  @Override
  public String body() {
    return body;
  }
}
