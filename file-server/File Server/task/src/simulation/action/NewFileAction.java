package simulation.action;

import common.FileService;
import common.action.Action;

public class NewFileAction implements Action {
  private final FileService fileService;
  private final String fileName;

  public NewFileAction(FileService fileService, String fileName) {
    this.fileService = fileService;
    this.fileName = fileName;
  }

  @Override
  public void perform() {
    final boolean isSucceed = fileService.add(fileName);
    if (isSucceed) {
      System.out.printf("The file %s added successfully%n", fileName);
    } else {
      System.out.printf("Cannot add the file %s%n", fileName);
    }
  }
}
