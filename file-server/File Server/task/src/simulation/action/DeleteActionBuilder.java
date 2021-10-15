package simulation.action;

import common.action.Action;
import common.FileService;
import common.action.builder.ActionBuilder;

import java.util.Arrays;
import java.util.List;

class DeleteActionBuilder implements ActionBuilder {
  private final FileService fileService;
  private List<String> args;

  public DeleteActionBuilder(FileService fileService) {
    this.fileService = fileService;
  }

  @Override
  public ActionBuilder withArgs(String... args) {
    this.args = Arrays.asList(args);
    return this;
  }

  @Override
  public Action build() {
    return new DeleteAction(fileService, args.get(0));
  }
}
