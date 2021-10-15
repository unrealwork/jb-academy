package common.action;

public interface ActionFactory {

  Action byType(final ActionType type);
}
