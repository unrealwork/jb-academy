package metro.printer;

import metro.route.Route;

class RouterPrinter implements Printer {
    private final Route route;

    RouterPrinter(Route route) {
        this.route = route;
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
