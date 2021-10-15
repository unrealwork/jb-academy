package simulation.action;

import common.action.Action;

class ExitAction implements Action {
  @Override
  public void perform() {
    System.exit(0);
  }
}
