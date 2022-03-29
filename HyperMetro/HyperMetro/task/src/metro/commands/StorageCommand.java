package metro.commands;

import metro.storage.SubwayStorage;

@FunctionalInterface
public interface StorageCommand {

    void run(SubwayStorage storage);
}
