package metro.route;

import metro.model.Transfer;
import metro.storage.SubwayStorage;

@FunctionalInterface
public interface RouteFinder {
    static RouteFinder shortest(SubwayStorage inMemorySubwayStorage) {
        return new ShortestRouteFinder(inMemorySubwayStorage);
    }

    Route find(Transfer start, Transfer end);

}
