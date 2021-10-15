package common;

public enum RespStatus {
  OK(200),
  RESTRICTED(403),
  NOT_FOUND(404);

  private final int code;

  RespStatus(int code) {
    this.code = code;
  }

  public static RespStatus fromMessage(String msg) {
    int code = Integer.parseInt(msg);
    for (RespStatus value : values()) {
      if (value.code == code) {
        return value;
      }
    }
    throw new IllegalStateException("Not possible to extract Response code from the message");
  }

  public String toMessage() {
    return Integer.toString(code);
  }

  public int getCode() {
    return code;
  }
}
