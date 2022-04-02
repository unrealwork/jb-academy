package metro.commands;

import metro.model.Transfer;
import metro.printer.Printer;
import metro.route.Route;
import metro.storage.SubwayStorage;

public class RouteCommand implements StorageCommand {
    private final Transfer t1;
    private final Transfer t2;

    public RouteCommand(Transfer t1, Transfer t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public void run(SubwayStorage storage) {
        final Route route = storage.route(t1, t2);
        Printer.route(route).print();
    }
}
