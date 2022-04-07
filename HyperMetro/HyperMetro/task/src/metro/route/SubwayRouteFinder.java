package metro.route;

import metro.storage.SubwayStorage;

abstract class SubwayRouteFinder implements RouteFinder {
    public SubwayStorage getStorage() {
        return storage;
    }

    private final SubwayStorage storage;

    SubwayRouteFinder(SubwayStorage storage) {
        this.storage = storage;
    }

}
