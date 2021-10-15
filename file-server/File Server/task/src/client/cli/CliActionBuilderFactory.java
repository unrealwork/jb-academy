package client.cli;

import common.action.ActionType;
import common.action.builder.ActionBuilder;
import common.action.builder.ActionBuilderFactory;

import java.io.PrintStream;
import java.util.Scanner;

public class CliActionBuilderFactory implements ActionBuilderFactory {
  private final Scanner scanner;
  private final PrintStream printStream;

  public CliActionBuilderFactory(Scanner scanner, PrintStream printStream) {
    this.scanner = scanner;
    this.printStream = printStream;
  }

  @Override
  public ActionBuilder byType(ActionType actionType) {
    return null;
  }
}
