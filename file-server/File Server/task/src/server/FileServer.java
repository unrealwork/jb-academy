package server;

import server.action.Action;
import server.action.ActionReader;
import server.action.DefaultActionReader;

public class FileServer {
  private final ActionReader actionReader;

  private FileServer() {
    actionReader = new DefaultActionReader();
  }

  public static FileServer simulation() {
    return new FileServer();
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
}
