package common;

public interface Response {
  public static Response parse(String message) {
    String[] parts = message.split("\\s+", 2);
    final RespStatus status = RespStatus.fromMessage(parts[0]);
    final String body = parts.length == 2 ? parts[1] : null;
    return new ResponseImpl(status, body);
  }

  public static Response of(final RespStatus status, final String content) {
    return new ResponseImpl(status, content);
  }

  default String asMessage() {
    String bodyPart = body() != null ? (" " + body()) : "";
    return status().getCode() + bodyPart;
  }

  RespStatus status();

  String body();
}
