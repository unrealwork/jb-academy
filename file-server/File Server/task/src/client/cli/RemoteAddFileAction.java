package client.cli;

import client.FileStatus;
import common.AdditionResult;
import common.FileService;
import common.action.Action;

public class RemoteAddFileAction implements Action {
  private final String fileName;
  private final FileService fileService;
  private final String content;

  public RemoteAddFileAction(String fileName, FileService fileService, String content) {
    this.fileName = fileName;
    this.fileService = fileService;
    this.content = content;
  }

  @Override
  public void perform() {
    final AdditionResult result = fileService.add(fileName, content);
    System.out.println("The request was sent.");
    if (result.getStatus() == FileStatus.SUCCESSFUL) {
      System.out.println("The response says that file was created!");
    } else {
      System.out.println("The response says that creating the file was forbidden!");
    }
  }
}
