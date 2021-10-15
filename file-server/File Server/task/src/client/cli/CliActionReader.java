package client.cli;

import client.RemoteFileService;
import client.ReqRespClientFactory;
import common.FileService;
import common.action.Action;
import common.action.ActionReader;
import common.action.ActionType;

import java.util.Map;
import java.util.Scanner;

public class CliActionReader implements ActionReader {
  private static final Map<String, ActionType> ACTION_TYPE_MAPPER =
      Map.of(
          "1", ActionType.GET,
          "2", ActionType.ADD,
          "3", ActionType.DELETE,
          "exit", ActionType.EXIT);

  private ActionType readActionType() {
    System.out.print("Enter action (1 - get a file, 2 - create a file, 3 - delete a file): ");
    return ACTION_TYPE_MAPPER.get(scanner().nextLine());
  }

  @Override
  public Action next() {
    final Scanner scanner = scanner();
    ActionType actionType = readActionType();
    switch (actionType) {
      case GET:
        return new GetCliActionBuilder(scanner, fileService()).build();
      case ADD:
        return new AddCliActionBuilder(scanner, fileService()).build();
      case DELETE:
        return new DeleteCliActionBuilder(scanner, fileService()).build();
      case EXIT:
        return new ExitCliActionBuilder(scanner, fileService()).build();
      default:
        throw new IllegalStateException("This action has not yet implemented");
    }
  }

  private Scanner scanner() {
    return new Scanner(System.in);
  }

  private FileService fileService() {
    return LazyHolder.FILE_SERVICE;
  }

  @Override
  public void close() {
    scanner().close();
  }

  private static class LazyHolder {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final FileService FILE_SERVICE =
        new RemoteFileService(ReqRespClientFactory.defaultClient());
  }
}
