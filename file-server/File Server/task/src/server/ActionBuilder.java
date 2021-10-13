package server;

public interface ActionBuilder {
  ActionBuilder withArgs(String... args);

  Action build();
}
