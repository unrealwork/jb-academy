package client.cli;

import common.FileService;
import common.action.Action;

public class RemoteExitAction implements Action {
    private final FileService fileService;

    public RemoteExitAction(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void perform() {
        fileService.exit();
    }
}
