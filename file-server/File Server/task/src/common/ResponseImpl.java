package common;

public class ResponseImpl implements Response {
  private final RespStatus status;
  private final String body;

  ResponseImpl(RespStatus status, String body) {
    this.status = status;
    this.body = body;
  }

  @Override
  public RespStatus status() {
    return status;
  }

  @Override
  public String body() {
    return body;
  }
}
