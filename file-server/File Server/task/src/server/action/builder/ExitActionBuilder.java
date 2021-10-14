package server.action.builder;

import server.action.Action;

public class ExitActionBuilder implements ActionBuilder {
  @Override
  public ActionBuilder withArgs(String... args) {
    return this;
  }

  @Override
  public Action build() {
    return new ExitAction();
  }
}
