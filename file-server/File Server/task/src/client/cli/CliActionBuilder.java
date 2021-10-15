package client.cli;

import common.FileService;
import common.action.builder.ActionBuilder;

import java.util.Scanner;

public abstract class CliActionBuilder implements ActionBuilder {
    protected final Scanner scanner;
    protected final FileService fileService;

    protected CliActionBuilder(Scanner scanner, FileService fileService) {
        this.scanner = scanner;
        this.fileService = fileService;
    }

    protected String readFileName() {
        System.out.print("Enter filename: ");
        return scanner.next();
    }

    protected Scanner scanner() {
        return scanner;
    }
}
