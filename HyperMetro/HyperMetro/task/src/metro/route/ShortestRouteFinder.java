package metro.route;

import metro.storage.SubwayStorage;

class ShortestRouteFinder extends SubwayRouteFinder {
    ShortestRouteFinder(SubwayStorage storage) {
        super(storage);
    }

    @Override
    public Route find() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
