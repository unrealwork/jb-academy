package common;

/** Allows different interactions with server */
public interface FileService {
  boolean add(final String name, final String content);

  default boolean add(final String name) {
    return add(name, null);
  }
  ;

  String get(final String name);

  boolean delete(final String name);
}
