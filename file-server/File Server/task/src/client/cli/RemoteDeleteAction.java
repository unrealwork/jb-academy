package client.cli;

import client.DeleteResult;
import client.FileStatus;
import common.FileService;
import common.action.Action;

public class RemoteDeleteAction implements Action {
  private final String fileName;
  private final FileService fileService;

  public RemoteDeleteAction(String fileName, FileService fileService) {
    this.fileName = fileName;
    this.fileService = fileService;
  }

  @Override
  public void perform() {
    DeleteResult deleteResult = fileService.delete(fileName);
    System.out.println("The request was sent.");
    if (deleteResult.getStatus() == FileStatus.SUCCESSFUL) {
      System.out.println("The response says that the file was successfully deleted!");
    } else {
      System.out.println("The response says that the file was not found!");
    }
  }
}
