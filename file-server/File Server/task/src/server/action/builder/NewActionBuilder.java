package server.action.builder;

import server.action.Action;
import server.action.NewFileAction;
import server.service.FileService;

import java.util.Arrays;
import java.util.List;

class NewActionBuilder implements ActionBuilder {
  private final FileService fileService;
  private List<String> args;

  public NewActionBuilder(FileService fileService) {
    this.fileService = fileService;
  }

  @Override
  public ActionBuilder withArgs(String... args) {
    this.args = Arrays.asList(args);
    return this;
  }

  @Override
  public Action build() {
    return new NewFileAction(fileService, args.get(0));
  }
}
