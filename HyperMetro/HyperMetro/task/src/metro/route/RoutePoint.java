package metro.route;

import metro.model.Transfer;

public class RoutePoint {
    private final Transfer station;
    private final Transfer transition;

    public Transfer getTransition() {
        return transition;
    }

    private RoutePoint(Transfer stations, Transfer transition) {
        this.station = stations;
        this.transition = transition;
    }

    private RoutePoint(Transfer transfer) {
        this(transfer, null);
    }

    static RoutePoint transition(Transfer stations, Transfer transition) {
        return new RoutePoint(stations, transition);
    }

    static RoutePoint point(Transfer transfer) {
        return new RoutePoint(transfer);
    }

    public boolean hasTransition() {
        return transition != null;
    }

    public Transfer getStation() {
        return station;
    }
}
