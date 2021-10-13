package server;

/**
 * Allows different interactions with server
 */
public interface FileService {
  boolean add(final String name);

  String get(final String name);

  boolean delete(final String name);
}
