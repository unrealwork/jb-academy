package metro.printer;

import metro.model.Transfer;
import metro.route.Route;
import metro.route.RoutePoint;

class RouterPrinter implements Printer {
    private final Route route;

    RouterPrinter(Route route) {
        this.route = route;
    }

    @Override
    public void print() {
        for (RoutePoint point : route.points()) {
            System.out.println(point.getStation().getStation());
            if (point.hasTransition()) {
                Transfer transition = point.getTransition();
                System.out.println("Transition to line " + transition.getLine());
                System.out.println(transition.getStation());
            }
        }

        if (route.dist() != null) {
            System.out.println("Total: " + route.dist() + " minutes in the way");
        }
    }
}
