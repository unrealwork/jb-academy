package server.action.builder;

import server.action.Action;

public class ExitAction implements Action {
  @Override
  public void perform() {
    System.exit(0);
  }
}
