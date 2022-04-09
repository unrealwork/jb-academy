package metro.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class StationVertex {
    private final Set<Transfer> transfers;

    private StationVertex(Set<Transfer> transfers) {
        this.transfers = transfers;
    }

    public static StationVertex fromStation(String line, Station station) {
        Set<Transfer> transfers = new LinkedHashSet<>(station.getTransfer());
        transfers.add(new Transfer(line, station.getName()));
        return new StationVertex(Collections.unmodifiableSet(transfers));
    }

    @Override
    public String toString() {
        return "StationVertex{" +
                "transfers=" + transfers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StationVertex that = (StationVertex) o;
        return Objects.equals(transfers, that.transfers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transfers);
    }

    public Set<Transfer> getTransfers() {
        return transfers;
    }
}
