package simulation.action;

import common.action.Action;
import common.action.builder.ActionBuilder;

class ExitActionBuilder implements ActionBuilder {
  @Override
  public ActionBuilder withArgs(String... args) {
    return this;
  }

  @Override
  public Action build() {
    return new ExitAction();
  }
}
