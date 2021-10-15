package simulation;

import client.DeleteResult;
import client.FileStatus;
import common.AdditionResult;
import common.FileService;
import common.action.GetResult;

import java.util.HashMap;
import java.util.Map;

/** Simulated implementation of {@link FileService}. */
public class FileServiceEmulation implements FileService {
  private static final int FILE_AMOUNT = 10;
  private static final Map<String, Boolean> STORAGE = initFilesStorage();

  private static Map<String, Boolean> initFilesStorage() {
    Map<String, Boolean> res = new HashMap<>();
    for (int i = 0; i < FILE_AMOUNT; i++) {
      res.put("file" + (i + 1), false);
    }
    return res;
  }

  @Override
  public AdditionResult add(String name, String content) {
    if (STORAGE.containsKey(name)) {
      final boolean isFileExist = STORAGE.get(name);
      if (isFileExist) {
        return AdditionResult.of(FileStatus.FORBIDDEN);
      } else {
        STORAGE.put(name, true);
        return AdditionResult.of(FileStatus.SUCCESSFUL);
      }
    }
    return AdditionResult.of(FileStatus.FORBIDDEN);
  }

  @Override
  public GetResult get(String name) {
    if (STORAGE.containsKey(name) && Boolean.TRUE.equals(STORAGE.get(name))) {
      return GetResult.of(FileStatus.SUCCESSFUL, name, null);
    }
    return GetResult.of(FileStatus.NOT_FOUND, name, null);
  }

  @Override
  public DeleteResult delete(String name) {
    if (STORAGE.containsKey(name) && Boolean.TRUE.equals(STORAGE.get(name))) {
      STORAGE.put(name, false);
      return DeleteResult.of(FileStatus.SUCCESSFUL, name);
    }
    return DeleteResult.of(FileStatus.NOT_FOUND, name);
  }

  @Override
  public void exit() {
    System.exit(0);
  }
}
