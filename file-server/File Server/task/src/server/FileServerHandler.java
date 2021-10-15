package server;

import client.DeleteResult;
import client.FileStatus;
import common.AdditionResult;
import common.FileService;
import common.PutRequest;
import common.Request;
import common.RespStatus;
import common.Response;
import common.action.GetResult;

import java.io.IOException;

public class FileServerHandler implements Handler<Request, Response> {
  private final FileService fileService;
  private final ReqRespServer server;

  public FileServerHandler(FileService fileService, ReqRespServer server) {
    this.fileService = fileService;
    this.server = server;
  }

  @Override
  public void handle(Request req, Session<Response, Request> session) {
    try {
      switch (req.type()) {
        case GET:
          GetResult result = fileService.get(req.path());
          session.sendMessage(Response.of(fromFileStatus(result.getStatus()), result.getContent()));
          break;
        case PUT:
          PutRequest putRequest = (PutRequest) req;
          AdditionResult additionResult = fileService.add(req.path(), putRequest.body());
          session.sendMessage(Response.of(fromFileStatus(additionResult.getStatus()), null));
          break;
        case DELETE:
          DeleteResult deleteResult = fileService.delete(req.path());
          final Response response =
              Response.of(fromFileStatus(deleteResult.getStatus()), deleteResult.getFileName());
          session.sendMessage(response);
          break;
        case EXIT:
          server.stop();
          break;
      }
    } catch (IOException e) {
      throw new IllegalStateException("Failed to handle request" + req.toMessage());
    }
  }

  private RespStatus fromFileStatus(final FileStatus status) {
    switch (status) {
      case SUCCESSFUL:
        return RespStatus.OK;
      case FORBIDDEN:
        return RespStatus.RESTRICTED;
      case NOT_FOUND:
        return RespStatus.NOT_FOUND;
      default:
        throw new UnsupportedOperationException();
    }
  }
}
