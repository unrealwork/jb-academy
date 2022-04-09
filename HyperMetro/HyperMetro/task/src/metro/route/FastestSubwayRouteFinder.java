package metro.route;

import metro.ds.GraphUtils;
import metro.ds.WeightedPath;
import metro.model.Transfer;
import metro.storage.SubwayStorage;

import java.util.Iterator;
import java.util.Objects;

public class FastestSubwayRouteFinder extends SubwayRouteFinder {
    FastestSubwayRouteFinder(SubwayStorage storage) {
        super(storage);
    }

    @Override
    public Route find(Transfer start, Transfer end) {
        final WeightedPath<Transfer> wPath = GraphUtils.fastestPath(getStorage().asWeightedGraph(), start, end);
        String prevLine = null;
        final RouteBuilder rb = new RouteBuilder(start);
        Iterator<Transfer> iterator = wPath.getPath().iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Transfer transfer = iterator.next();
            if (prevLine == null || Objects.equals(transfer.getLine(), prevLine)) {
                rb.point(transfer);
            } else {
                rb.transition(transfer);
            }
            prevLine = transfer.getLine();
        }
        return rb.dist(wPath.getDist())
                .build();
    }
}
