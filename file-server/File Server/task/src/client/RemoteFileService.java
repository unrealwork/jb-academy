package client;

import common.FileService;
import common.GetRequest;
import common.PutRequest;
import common.RespStatus;

public class RemoteFileService implements FileService {
  private final ReqRespClient reqRespClient;

  public RemoteFileService(ReqRespClient reqRespClient) {
    this.reqRespClient = reqRespClient;
  }

  @Override
  public boolean add(String name, String content) {
    RespStatus status = reqRespClient.send(new PutRequest(content));
    return status == RespStatus.OK;
  }

  @Override
  public String get(String name) {
    return null;
  }

  @Override
  public boolean delete(String name) {
    return false;
  }
  
  private 
}
