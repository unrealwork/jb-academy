package metro.commands;

import metro.model.Transfer;
import metro.printer.Printer;
import metro.route.Route;
import metro.route.RouteFinder;
import metro.storage.SubwayStorage;

public class FastestRouteCommand implements StorageCommand {
    private final Transfer start;
    private final Transfer end;

    public FastestRouteCommand(Transfer t1, Transfer t2) {
        this.start = t1;
        this.end = t2;
    }

    @Override
    public void run(SubwayStorage storage) {
        Route route = RouteFinder
                .fastest(storage)
                .find(start, end);
        Printer.route(route).print();
    }
}
