package client.cli;

import common.FileService;
import common.action.Action;
import common.action.builder.ActionBuilder;

import java.util.Scanner;

public class DeleteCliActionBuilder extends CliActionBuilder{
    public DeleteCliActionBuilder(Scanner scanner, FileService fileService) {
        super(scanner, fileService);
    }

    @Override
    public ActionBuilder withArgs(String... args) {
        return this;
    }

    @Override
    public Action build() {
        return new RemoteDeleteAction(readFileName(), fileService);
    }
}
