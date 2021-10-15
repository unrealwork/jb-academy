package common.action;

/** Type of action that can be selected by user. */
public enum ActionType {
  GET(),
  ADD(),
  DELETE(),
  EXIT();

  public static ActionType from(String part) {
    for (ActionType value : values()) {
      if (value.name().equalsIgnoreCase(part)) {
        return value;
      }
    }
    return null;
  }
}
