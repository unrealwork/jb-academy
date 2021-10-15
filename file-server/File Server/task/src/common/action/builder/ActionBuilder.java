package common.action.builder;

import common.action.Action;

public interface ActionBuilder {
  ActionBuilder withArgs(String... args);

  Action build();
}
