package common;

import client.FileStatus;

public class AdditionResult {
  private final FileStatus status;

  private AdditionResult(FileStatus status) {
    this.status = status;
  }

  public static AdditionResult of(FileStatus status) {
    return new AdditionResult(status);
  }

  public FileStatus getStatus() {
    return status;
  }
}
