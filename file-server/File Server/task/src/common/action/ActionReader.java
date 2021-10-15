package common.action;

public interface ActionReader extends AutoCloseable {
  Action next();
}
