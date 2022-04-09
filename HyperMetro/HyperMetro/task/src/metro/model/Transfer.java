package metro.model;

import java.util.Objects;

public class Transfer {
    private String line;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transfer transfer = (Transfer) o;
        return Objects.equals(line, transfer.line) && Objects.equals(station, transfer.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, station);
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "line='" + line + '\'' +
                ", station='" + station + '\'' +
                '}';
    }

    public Transfer(String line, String station) {
        this.line = line;
        this.station = station;
    }

    private String station;

    public String getLine() {
        return line;
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
