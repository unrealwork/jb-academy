package metro.model;

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
