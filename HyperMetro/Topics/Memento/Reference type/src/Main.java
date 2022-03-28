
import java.util.*;

class Originator {
    private int[][] array;

    public Originator(int[][] array) {
        this.array = clone(array);
    }

    public void setNumber(int position, int number) {
        array[position / array[0].length][position % array[0].length] = number;
    }

    public int[][] getArray() {
        return array.clone();
    }

    public Memento getMemento() {
        return new Memento(array);
    }

    public void setMemento(Memento memento) {
        this.array = clone(memento.arr);
    }

    private static int[][] clone(int[][] array) {
        final int[][] copy = array.clone();
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i].clone();
        }
        return copy;
    }

    static class Memento {
        private final int[][] arr;

        public Memento(int[][] arr) {
            this.arr = Originator.clone(arr);
        }
    }
}

class Caretaker {
    private final Originator originator;
    private Originator.Memento snapshot = null;

    public Caretaker(Originator originator) {
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
