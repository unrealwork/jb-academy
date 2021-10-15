package client.cli;

import common.FileService;
import common.action.Action;
import common.action.builder.ActionBuilder;

import java.util.Scanner;

public class GetCliActionBuilder extends CliActionBuilder {

  public GetCliActionBuilder(Scanner scanner, FileService fileService) {
    super(scanner, fileService);
  }

  @Override
  public ActionBuilder withArgs(String... args) {
    return null;
  }

  @Override
  public Action build() {
    return new RemoteGetFileAction(readFileName(), fileService);
  }
}
