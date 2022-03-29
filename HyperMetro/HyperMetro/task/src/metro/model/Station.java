package metro.model;

import java.util.ArrayList;
import java.util.List;

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
}
