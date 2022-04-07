package metro.route;

import metro.ds.GraphUtils;
import metro.model.Station;
import metro.model.StationVertex;
import metro.model.Transfer;
import metro.storage.SubwayStorage;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

class ShortestRouteFinder extends SubwayRouteFinder {
    ShortestRouteFinder(SubwayStorage storage) {
        super(storage);
    }

    private StationVertex stationFromTransfer(final Transfer t) {
        Station station = getStorage()
                .findStation(t.getLine(), t.getStation());
        return StationVertex.fromStation(t.getLine(), station);
    }

    @Override
    public Route find(final Transfer start, Transfer end) {
        final StationVertex startV = stationFromTransfer(start);
        final StationVertex endV = stationFromTransfer(end);
        List<StationVertex> path = GraphUtils.shortestPath(getStorage().asGraph(), startV, endV);
        RouteBuilder rb = new RouteBuilder(start);
        Iterator<StationVertex> iterator = path.iterator();
        Transfer pTransfer = start;
        StationVertex p = iterator.next();
        while (iterator.hasNext()) {
            StationVertex cur = iterator.next();
            Transfer byPrevLine = byLine(pTransfer.getLine(), cur);
            if (byPrevLine != null) {
                rb.point(byPrevLine);
                pTransfer = byPrevLine;
            } else {
                addTransition(rb, p, cur);
                pTransfer = rb.last();
            }
            p = cur;
        }
        return rb.build();
    }

    private void addTransition(RouteBuilder rb, final StationVertex cur, StationVertex next) {
        boolean found = false;
        for (Transfer transfer : cur.getTransfers()) {
            for (Transfer nextTransfer : next.getTransfers()) {
                final boolean sameLine = Objects.equals(transfer.getLine(), nextTransfer.getLine());
                if (sameLine) {
                    if (found) {
                        throw new IllegalStateException("Multiple Transitions");
                    }
                    rb.transition(transfer);
                    rb.point(nextTransfer);
                    found = true;
                }
            }
        }
        if (!found) {
            throw new IllegalStateException("Should contains one transition");
        }
    }

    private Transfer byLine(final String line, StationVertex vertex) {
        return vertex.getTransfers().stream()
                .filter(t -> Objects.equals(t.getLine(), line))
                .findAny().orElse(null);
    }
}
