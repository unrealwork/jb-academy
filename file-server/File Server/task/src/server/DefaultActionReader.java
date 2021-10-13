package server;

import java.util.Scanner;

public class DefaultActionReader implements ActionReader, AutoCloseable {

  @Override
  public Action next() {
    final Scanner scanner = scanner();
    if (scanner.hasNextLine()) {
      final String line = scanner.nextLine();
      String[] parts = line.split("\\s", 2);
      ActionType type = ActionType.from(parts[0]);
      ActionFactory actionFactory = ActionFactory.simulation();
      return actionFactory.byType(type);
    }
    return null;
  }

  private Scanner scanner() {
    return ScannerLazyHolder.SCANNER;
  }

  @Override
  public void close() throws Exception {
    scanner().close();
  }

  private static class ScannerLazyHolder {
    private static final Scanner SCANNER = new Scanner(System.in);
  }
}
