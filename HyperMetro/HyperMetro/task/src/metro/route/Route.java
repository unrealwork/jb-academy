package metro.route;

import java.util.List;

public interface Route {
    List<RoutePoint> points();

    RoutePoint last();
}
