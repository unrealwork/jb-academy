package common.action;

import client.FileStatus;

public class GetResult {
  private final FileStatus status;
  private final String fileName;
  private final String content;

  private GetResult(FileStatus status, String fileName, String content) {
    this.status = status;
    this.fileName = fileName;
    this.content = content;
  }

  public static GetResult of(FileStatus status, String fileName, String content) {
    return new GetResult(status, fileName, content);
  }

  public FileStatus getStatus() {
    return status;
  }

  public String getFileName() {
    return fileName;
  }

  public String getContent() {
    return content;
  }
}
