package client.cli;

import common.FileService;
import common.action.Action;
import common.action.builder.ActionBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AddCliActionBuilder extends CliActionBuilder {
  public AddCliActionBuilder(Scanner scanner, FileService fileService) {
    super(scanner, fileService);
  }

  @Override
  public ActionBuilder withArgs(String... args) {
    return this;
  }

  @Override
  public Action build() {
    return new RemoteAddFileAction(readFileName(), fileService, readContent());
  }

  private String readContent() {
    System.out.print("Enter file content: ");
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      return reader.readLine();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
