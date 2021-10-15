package simulation.action;

import common.FileService;
import common.action.Action;

public class GetFileAction implements Action {
  private final FileService fileService;
  private final String fileName;

  public GetFileAction(FileService fileService, String s) {
    this.fileService = fileService;
    this.fileName = s;
  }

  @Override
  public void perform() {
    final String file = fileService.get(fileName);
    if (file != null) {
      System.out.printf("The file %s was sent%n", fileName);
    } else {
      System.out.printf("The file %s not found%n", fileName);
    }
  }
}
