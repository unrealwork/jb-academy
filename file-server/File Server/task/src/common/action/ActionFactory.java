package common.action;

import simulation.SimulationActionFactory;

public interface ActionFactory {
  static ActionFactory simulation() {
    return new SimulationActionFactory();
  }

  Action byType(final ActionType type);
}
