package animals.storage;

import animals.lang.Fact;
import animals.lang.Subject;

public interface FactStorage {
    void add(Fact fact, Subject s);

    boolean has(Fact fact, Subject s);

    static FactStorage create() {
        return new FactStorageImpl();
    }
}
