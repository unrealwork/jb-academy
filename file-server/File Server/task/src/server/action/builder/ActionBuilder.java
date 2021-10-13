package server.action.builder;

import server.action.Action;

public interface ActionBuilder {
  ActionBuilder withArgs(String... args);

  Action build();
}
