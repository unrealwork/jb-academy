package server.action;

import server.action.builder.ActionBuilderFactory;

import java.util.Scanner;

public class DefaultActionReader implements ActionReader {
  private final ActionBuilderFactory actionBuilderFactory = ActionBuilderFactory.get();

  @Override
  public Action next() {
    final Scanner scanner = scanner();
    if (scanner.hasNextLine()) {
      final String line = scanner.nextLine();
      String[] parts = line.split("\\s", 2);
      ActionType type = ActionType.from(parts[0]);
      final String[] args = parts.length == 2 ? parts[1].split("\\s+") : new String[] {};
      return actionBuilderFactory.byType(type).withArgs(args).build();
    }
    return null;
  }

  private Scanner scanner() {
    return ScannerLazyHolder.SCANNER;
  }

  @Override
  public void close() {
    scanner().close();
  }

  private static class ScannerLazyHolder {
    private static final Scanner SCANNER = new Scanner(System.in);
  }
}
