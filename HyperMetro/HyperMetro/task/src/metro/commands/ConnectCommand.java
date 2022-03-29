package metro.commands;

import metro.model.Transfer;
import metro.storage.SubwayStorage;

public class ConnectCommand implements StorageCommand {
    private final Transfer transfer1;
    private final Transfer transfer2;

    public ConnectCommand(Transfer transfer1, Transfer transfer2) {
        this.transfer1 = transfer1;
        this.transfer2 = transfer2;
    }

    @Override
    public void run(SubwayStorage storage) {
        storage.connect(transfer1, transfer2);
    }
}
