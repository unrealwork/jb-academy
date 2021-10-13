package server;

/** Type of action that can be selected by user. */
public enum ActionType {
  GET(null),
  ADD(null),
  DELETE(null),
  EXIT(null);

  private final Action action;

  ActionType(Action action) {
    this.action = action;
  }

  public static ActionType from(String part) {
    return null;
  }

  public Action action() {
    return action;
  }
}
