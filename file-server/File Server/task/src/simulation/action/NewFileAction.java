package simulation.action;

import client.FileStatus;
import common.AdditionResult;
import common.FileService;
import common.action.Action;

public class NewFileAction implements Action {
  private final FileService fileService;
  private final String fileName;
  private final String content;

  public NewFileAction(FileService fileService, String fileName, String content) {
    this.fileService = fileService;
    this.fileName = fileName;
    this.content = content;
  }

  @Override
  public void perform() {
    final AdditionResult result = fileService.add(fileName, content);
    if (result.getStatus() == FileStatus.SUCCESSFUL) {
      System.out.printf("The file %s added successfully%n", fileName);
    } else {
      System.out.printf("Cannot add the file %s%n", fileName);
    }
  }
}
