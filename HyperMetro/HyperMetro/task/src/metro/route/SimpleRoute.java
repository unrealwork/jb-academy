package metro.route;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class SimpleRoute implements Route {
    private final Deque<RoutePoint> routePoints;
    private final Integer dist;

    SimpleRoute(List<RoutePoint> routePoints, Integer dist) {
        this.routePoints = new ArrayDeque<>(routePoints);
        this.dist = dist;
    }

    @Override
    public List<RoutePoint> points() {
        return new ArrayList<>(routePoints);
    }

    @Override
    public Integer dist() {
        return dist;
    }

    @Override
    public RoutePoint last() {
        return routePoints.poll();
    }
}
