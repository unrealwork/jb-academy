package metro.model;

import java.util.Objects;

public class Transfer {
    private String line;

    public Transfer(String line, String station) {
        this.line = line;
        this.station = station;
    }

    private String station;

    public String getLine() {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transfer transfer = (Transfer) o;
        return Objects.equals(station, transfer.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(station);
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
