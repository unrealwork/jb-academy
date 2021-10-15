package client;

import common.AdditionResult;
import common.DeleteRequest;
import common.FileService;
import common.GetRequest;
import common.PutRequest;
import common.RespStatus;
import common.Response;
import common.action.GetResult;

import java.io.IOException;

public class RemoteFileService implements FileService {
  private final ReqRespClient reqRespClient;

  public RemoteFileService(ReqRespClient reqRespClient) {
    this.reqRespClient = reqRespClient;
  }

  @Override
  public AdditionResult add(String name, String content) {
    try {
      Response resp = reqRespClient.request(new PutRequest(name, content));
      final FileStatus status =
          resp.status() == RespStatus.OK ? FileStatus.SUCCESSFUL : FileStatus.FORBIDDEN;
      return AdditionResult.of(status);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public GetResult get(String name) {
    try {
      Response status = reqRespClient.request(new GetRequest(name));
      if (status.status() == RespStatus.OK) {
        return GetResult.of(FileStatus.SUCCESSFUL, name, status.body());
      } else {
        return GetResult.of(FileStatus.NOT_FOUND, name, status.body());
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public DeleteResult delete(String name) {
    try {
      Response resp = reqRespClient.request(new DeleteRequest(name));
      final FileStatus status =
          resp.status() == RespStatus.OK ? FileStatus.SUCCESSFUL : FileStatus.NOT_FOUND;
      return DeleteResult.of(status, name);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public void exit() {
    try {
      reqRespClient.send(new ExitRequest());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
