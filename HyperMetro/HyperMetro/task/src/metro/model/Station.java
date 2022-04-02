package metro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
        this.transfer = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addTransfer(final String lineName, String station) {
        addTransfer(new Transfer(lineName, station));
    }


    public List<Transfer> getTransfer() {
        return transfer;
    }

    public void setTransfer(List<Transfer> transfer) {
        this.transfer = transfer;
    }

    private List<Transfer> transfer;

    public void addTransfer(Transfer station2) {
        transfer.add(station2);
    }

    public boolean hasTransfer() {
        return transfer != null && !transfer.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
