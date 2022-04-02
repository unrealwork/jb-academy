package metro.route;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class SimpleRoute implements Route {
    private final Deque<RoutePoint> routePoints;

    SimpleRoute(List<RoutePoint> routePoints) {
        this.routePoints = new ArrayDeque<>(routePoints);
    }

    @Override
    public List<RoutePoint> points() {
        return new ArrayList<>(routePoints);
    }

    @Override
    public RoutePoint last() {
        return routePoints.poll();
    }
}
