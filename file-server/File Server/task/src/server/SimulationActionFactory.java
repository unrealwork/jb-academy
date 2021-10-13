package server;

import java.util.EnumMap;

public class SimulationActionFactory implements ActionFactory {
  private static final EnumMap<ActionType, Action> ACTION_STORAGE = new EnumMap<>(ActionType.class);

  @Override
  public Action byType(ActionType type) {
    return ACTION_STORAGE.computeIfAbsent(type, ActionType::action);
  }
}
