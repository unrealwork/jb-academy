package client;

import client.cli.CliActionReader;
import common.action.Action;

@SuppressWarnings("squid:S106")
public class Main {
  public static void main(String[] args) {
    try (CliActionReader reader = new CliActionReader()) {
      Action action = reader.next();
      action.perform();
    }
  }
}
