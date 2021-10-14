package server;

import server.action.Action;
import server.action.ActionReader;
import server.action.DefaultActionReader;

public class SimulationFileServer implements AutoCloseable {
  private final ActionReader actionReader;

  private SimulationFileServer() {
    actionReader = new DefaultActionReader();
  }

  public static SimulationFileServer simulation() {
    return new SimulationFileServer();
  }

  public void start() {
    while (true) {
      Action action = actionReader.next();
      if (action == null) {
        break;
      }
      action.perform();
    }
  }

  @Override
  public void close() throws Exception {
    actionReader.close();
  }
}
