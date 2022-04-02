package metro.route;

import metro.storage.SubwayStorage;

@FunctionalInterface
public interface RouteFinder {
    static RouteFinder shortest(SubwayStorage inMemorySubwayStorage) {
        return new ShortestRouteFinder(inMemorySubwayStorage);
    }

    Route find();
}
