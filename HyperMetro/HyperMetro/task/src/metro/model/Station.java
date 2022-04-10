package metro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station {
    private String name;
    private int time;
    private List<Transfer> transfer;
    private List<String> next;
    private List<String> prev;

    public Station(String name) {
        this.name = name;
        this.transfer = new ArrayList<>();
    }

    public List<String> getNext() {
        return next;
    }

    public void setNext(List<String> next) {
        this.next = next;
    }

    public List<String> getPrev() {
        return prev;
    }

    public void setPrev(List<String> prev) {
        this.prev = prev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transfer> getTransfer() {
        return transfer;
    }

    public void setTransfer(List<Transfer> transfer) {
        this.transfer = transfer;
    }

    public void addTransfer(Transfer station2) {
        transfer.add(station2);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", transfer=" + transfer +
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
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
