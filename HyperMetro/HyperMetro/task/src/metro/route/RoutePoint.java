package metro.route;

import metro.model.Transfer;

public class RoutePoint {
    private final Transfer station;
    private final Transfer transition;

    private RoutePoint(Transfer stations, Transfer transition) {
        this.station = stations;
        this.transition = transition;
    }

    private RoutePoint(Transfer transfer) {
        this(transfer, null);
    }

    public boolean hasTransition() {
        return transition != null;
    }
}
