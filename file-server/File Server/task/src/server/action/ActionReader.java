package server.action;

public interface ActionReader extends AutoCloseable {
  Action next();
}
