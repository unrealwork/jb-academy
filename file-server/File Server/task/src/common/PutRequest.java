package common;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PutRequest implements Request, Bodied {
  private final String fileName;
  private final InputStream is;
  private String body;

  public PutRequest(String fileName, InputStream is) {
    this.fileName = fileName;
    this.body = body;
    this.is = is;
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
  public InputStream getInputStream() {
    return is;
  }

  @Override
  public String body() {
    if (body == null) {
      try (DataInputStream dis = new DataInputStream(is)) {
        this.body = dis.readUTF();
      } catch (IOException e) {
        throw new IllegalStateException(e);
      }
    }
    return this.body;
  }
}
