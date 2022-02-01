import java.util.*;

class Originator {
    private List<Integer> numbers = new ArrayList<>();

    public void addNumber(Integer number) {
        numbers.add(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Memento getMemento() {
        return new Memento(numbers);
    }

    public void setMemento(Memento memento) {
        this.numbers = memento.getState();
    }
}

class Caretaker {
    private final Originator originator;
    private Memento snapshot = null;

    Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void save() {
        snapshot = originator.getMemento();
    }

    public void restore() {
        if (snapshot != null) {
            originator.setMemento(snapshot);
        }
    }
}

class Memento {
    private final List<Integer> state;

    Memento(List<Integer> state) {
        this.state = new ArrayList<>(state);
    }

    List<Integer> getState() {
        return new ArrayList<>(state);
    }
}
