package simulation.action;

import client.DeleteResult;
import client.FileStatus;
import common.FileService;
import common.action.Action;

class DeleteAction implements Action {
  private final FileService fileService;
  private final String fileName;

  public DeleteAction(FileService fileService, String s) {
    this.fileService = fileService;
    this.fileName = s;
  }

  @Override
  public void perform() {
    final DeleteResult result = fileService.delete(fileName);
    if (result.getStatus() == FileStatus.SUCCESSFUL) {
      System.out.printf("The file %s was deleted%n", fileName);
    } else {
      System.out.printf("The file %s not found%n", fileName);
    }
  }
}
