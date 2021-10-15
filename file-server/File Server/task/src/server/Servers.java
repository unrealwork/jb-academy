package server;

import common.FileService;

public class Servers {
  private Servers() {}

  public static ReqRespServer file() {
    MessageServer messageServer = PlainMessageServer.socket();
    ReqRespServer respServer = new ReqRespServer(messageServer);
    FileService fileService = new LocalFileService();
    respServer.addMessageCallback(new FileServerHandler(fileService, respServer));
    return respServer;
  }
}
