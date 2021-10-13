package server.action.builder;

import server.action.ActionType;
import server.service.FileService;
import server.service.FileServiceEmulation;

public class ActionBuilderFactory {
  private ActionBuilderFactory() {}

  public static ActionBuilderFactory get() {
    return new ActionBuilderFactory();
  }

  public ActionBuilder byType(ActionType actionType) {
    switch (actionType) {
      case ADD:
        return new NewActionBuilder(fileService());
      case GET:
        return new GetActionBuilder(fileService());
      case DELETE:
        return new DeleteActionBuilder(fileService());
      case EXIT:
        return new ExitActionBuilder();
    }
    return null;
  }

  private FileService fileService() {
    return LazyHolder.FILE_SERVICE;
  }

  private static class LazyHolder {
    private static final FileService FILE_SERVICE = new FileServiceEmulation();
  }
}
