package metro.route;

import metro.model.Transfer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RouteBuilder {
    private final Deque<RoutePoint> transfers;
    private Integer dist;

    public RouteBuilder(Transfer start) {
        this.transfers = new ArrayDeque<>();
        transfers.add(RoutePoint.point(start));
    }

    public RouteBuilder(RouteBuilder routeBuilder) {
        this.transfers = new ArrayDeque<>(routeBuilder.transfers);
    }

    public RouteBuilder point(Transfer transfer) {
        transfers.add(RoutePoint.point(transfer));
        return this;
    }

    public RouteBuilder dist(int dist) {
        this.dist = dist;
        return this;
    }


    public RouteBuilder transition(Transfer transitionStation) {
        RoutePoint last = transfers.pollLast();
        if (last == null || last.hasTransition()) {
            throw new IllegalStateException();
        }
        transfers.add(RoutePoint.transition(last.getStation(), transitionStation));
        return this;
    }

    public Route build() {
        return new SimpleRoute(new ArrayList<>(transfers), dist);
    }

    public Transfer last() {
        RoutePoint lastRoutePoint = this.transfers.peek();
        if (lastRoutePoint == null) {
            throw new IllegalStateException("Empty route");
        }
        return lastRoutePoint.hasTransition() ? lastRoutePoint.getTransition() : lastRoutePoint.getStation();
    }
}
