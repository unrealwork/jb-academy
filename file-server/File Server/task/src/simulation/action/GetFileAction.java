package simulation.action;

import client.FileStatus;
import common.FileService;
import common.action.Action;
import common.action.GetResult;

public class GetFileAction implements Action {
  private final FileService fileService;
  private final String fileName;

  public GetFileAction(FileService fileService, String s) {
    this.fileService = fileService;
    this.fileName = s;
  }

  @Override
  public void perform() {
    final GetResult file = fileService.get(fileName);
    if (file.getStatus() == FileStatus.SUCCESSFUL) {
      System.out.printf("The file %s was sent%n", fileName);
    } else {
      System.out.printf("The file %s not found%n", fileName);
    }
  }
}
