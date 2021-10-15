package client.cli;

import client.FileStatus;
import common.FileService;
import common.action.Action;
import common.action.GetResult;

public class RemoteGetFileAction implements Action {
  private final String fileName;
  private final FileService fileService;

  public RemoteGetFileAction(String fileName, FileService fileService) {
    this.fileName = fileName;
    this.fileService = fileService;
  }

  @Override
  public void perform() {
    final GetResult content = fileService.get(fileName);
    System.out.println("The request was sent.");
    if (content.getStatus() == FileStatus.NOT_FOUND) {
      System.out.println("The response says that the file was not found!");
    } else {
      System.out.println("The content of the file is: " + content.getContent());
    }
  }
}
