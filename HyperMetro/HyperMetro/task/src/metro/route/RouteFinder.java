package metro.route;

import metro.model.Transfer;
import metro.storage.SubwayStorage;

@FunctionalInterface
public interface RouteFinder {
    static RouteFinder shortest(SubwayStorage inMemorySubwayStorage) {
        return new ShortestRouteFinder(inMemorySubwayStorage);
    }

    static RouteFinder fastest(SubwayStorage storage) {
        return new FastestSubwayRouteFinder(storage);
    }

    Route find(Transfer start, Transfer end);

}
