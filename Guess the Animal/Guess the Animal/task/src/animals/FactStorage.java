package animals;

public interface FactStorage {
    void add(Fact fact, Subject s);

    boolean has(Fact fact, Subject s);

    static FactStorage create() {
        return new FactStorageImpl();
    }
}
