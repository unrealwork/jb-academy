package simulation.action;

import common.action.Action;
import common.FileService;

class DeleteAction implements Action {
  private final FileService fileService;
  private final String fileName;

  public DeleteAction(FileService fileService, String s) {
    this.fileService = fileService;
    this.fileName = s;
  }

  @Override
  public void perform() {
    final boolean isSucceed = fileService.delete(fileName);
    if (isSucceed) {
      System.out.printf("The file %s was deleted%n", fileName);
    } else {
      System.out.printf("The file %s not found%n", fileName);
    }
  }
}
