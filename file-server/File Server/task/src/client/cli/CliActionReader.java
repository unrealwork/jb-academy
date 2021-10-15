package client.cli;

import common.FileService;
import common.action.Action;
import common.action.ActionReader;
import common.action.ActionType;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

public class CliActionReader implements ActionReader {
  private static final Map<String, ActionType> ACTION_TYPE_MAPPER =
      Map.of(
          "1", ActionType.GET,
          "2", ActionType.ADD,
          "3", ActionType.DELETE,
          "exit", ActionType.EXIT);
  private final PrintStream out;
  private final FileService fileService;

  public CliActionReader(FileService fileService) {
    this.fileService = fileService;
    this.out = System.out;
  }

  private ActionType readActionType() {
    return ACTION_TYPE_MAPPER.get(scanner().nextLine());
  }

  @Override
  public Action next() {
    final Scanner scanner = scanner();
    if (scanner.hasNextLine()) {
      ActionType actionType = readActionType();
      switch (actionType) {
        case GET:
          new GetCliActionBuilder(scanner, fileService).build();
        default:
          throw new IllegalStateException("This action has not yet implemented");
      }
    }
    return null;
  }

  private Scanner scanner() {
    return ScannerLazyHolder.SCANNER;
  }

  @Override
  public void close() {
    scanner().close();
  }

  private static class ScannerLazyHolder {
    private static final Scanner SCANNER = new Scanner(System.in);
  }
}
