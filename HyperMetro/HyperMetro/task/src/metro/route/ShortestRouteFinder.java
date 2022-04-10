package metro.route;

import metro.ds.GraphUtils;
import metro.ds.WeightedPath;
import metro.model.Transfer;
import metro.storage.SubwayStorage;

import java.util.Iterator;
import java.util.Objects;

class ShortestRouteFinder extends SubwayRouteFinder {
    ShortestRouteFinder(SubwayStorage storage) {
        super(storage);
    }

    @Override
    public Route find(final Transfer start, Transfer end) {
        final WeightedPath<Transfer> wPath = GraphUtils.fastestPath(getStorage().asTimelessGraph(), start, end);
        final RouteBuilder rb = new RouteBuilder(start);
        Iterator<Transfer> iterator = wPath.getPath().iterator();
        final Transfer first = iterator.next();
        String prevLine = first.getLine();
        while (iterator.hasNext()) {
            Transfer transfer = iterator.next();
            if (Objects.equals(transfer.getLine(), prevLine)) {
                rb.point(transfer);
            } else {
                rb.transition(transfer);
            }
            prevLine = transfer.getLine();
        }
        return rb.build();
    }

}
