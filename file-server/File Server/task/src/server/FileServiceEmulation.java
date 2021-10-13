package server;

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
  public boolean add(String name) {
    if (STORAGE.containsKey(name)) {
      final boolean isFileExist = STORAGE.get(name);
      if (isFileExist) {
        return false;
      } else {
        STORAGE.put(name, true);
        return true;
      }
    }
    return false;
  }

  @Override
  public String get(String name) {
    if (STORAGE.containsKey(name) && Boolean.TRUE.equals(STORAGE.get(name))) {
      return name;
    }
    return null;
  }

  @Override
  public boolean delete(String name) {
    return false;
  }
}
