package server.action;

public interface ActionFactory {
  static ActionFactory simulation() {
    return new SimulationActionFactory();
  }

  Action byType(final ActionType type);
}
