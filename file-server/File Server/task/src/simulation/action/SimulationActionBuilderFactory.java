package simulation.action;

import common.action.ActionType;
import common.FileService;
import common.action.builder.ActionBuilder;
import common.action.builder.ActionBuilderFactory;
import simulation.FileServiceEmulation;

public class SimulationActionBuilderFactory implements ActionBuilderFactory {
  private SimulationActionBuilderFactory() {}

  public static ActionBuilderFactory get() {
    return new SimulationActionBuilderFactory();
  }

  @Override
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
