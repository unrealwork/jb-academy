package common;

import client.DeleteResult;
import common.action.GetResult;

/** Allows different interactions with server */
public interface FileService {
  AdditionResult add(final String name, final String content);

  GetResult get(final String name);

  DeleteResult delete(final String name);

  void exit();
}
