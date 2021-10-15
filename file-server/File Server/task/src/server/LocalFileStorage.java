package server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class LocalFileStorage {
  private static final String STORAGE_PATH = System.getProperty("user.dir") +
          File.separator + "src" + File.separator + "server" + File.separator + "data" + File.separator;

  public LocalFileStorage() {
    init();
  }

  private void init() {
    try {
      final Path storagePath = Paths.get(STORAGE_PATH);
      if (!Files.exists(storagePath)) {
        Files.createDirectories(storagePath);
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  public Optional<Path> get(String fileName) {
    final Path path = Paths.get(STORAGE_PATH, fileName);
    if (Files.exists(path)) {
      return Optional.of(path);
    }
    return Optional.empty();
  }

  public Optional<Path> create(String fileName, String content) throws IOException {
    final Path path = Paths.get(STORAGE_PATH, fileName);
    if (Files.exists(path)) {
      return Optional.empty();
    }
    Path createdPath = Files.createFile(path);
    Files.writeString(createdPath, content);
    return Optional.of(createdPath);
  }

  public boolean delete(String fileName) throws IOException {
    final Path path = Paths.get(STORAGE_PATH, fileName);
    if (Files.exists(path)) {
      Files.delete(path);
      return true;
    }
    return false;
  }

}
