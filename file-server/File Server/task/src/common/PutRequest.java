package common;

public class PutRequest implements Request, Bodied {
  private final String fileName;
  private final String body;

  public PutRequest(String fileName, String body) {
    this.fileName = fileName;
    this.body = body;
  }

  @Override
  public ReqType type() {
    return ReqType.PUT;
  }

  @Override
  public String path() {
    return fileName;
  }

  @Override
  public String toMessage() {
    return type() + " " + path() + " " + body();
  }

  @Override
  public String body() {
    return body;
  }
}
