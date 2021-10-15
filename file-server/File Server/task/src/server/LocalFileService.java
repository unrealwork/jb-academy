package server;

import client.DeleteResult;
import client.FileStatus;
import common.AdditionResult;
import common.FileService;
import common.action.GetResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class LocalFileService implements FileService {
  private final LocalFileStorage localStorage = new LocalFileStorage();

  private static String readContent(Path path) throws IOException {
    return Files.readString(path);
  }
  
  
  
  
  @Override
  public AdditionResult add(String name, String content) {
    try {
      Optional<Path> path = localStorage.create(name, content);

      return AdditionResult.of(
              path.isPresent() ? FileStatus.SUCCESSFUL : FileStatus.FORBIDDEN);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public GetResult get(String name) {
    try {
      final Optional<Path> path = localStorage.get(name);
      if (path.isPresent()) {
        return GetResult.of(FileStatus.SUCCESSFUL, name, readContent(path.get()));
      } else {
        return GetResult.of(FileStatus.NOT_FOUND, name, null);
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public DeleteResult delete(String name) {
    try {
      final boolean isSuccessful = localStorage.delete(name);
      return DeleteResult.of(isSuccessful ? FileStatus.SUCCESSFUL : FileStatus.NOT_FOUND, name);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public void exit() {
    System.exit(0);
  }
}
