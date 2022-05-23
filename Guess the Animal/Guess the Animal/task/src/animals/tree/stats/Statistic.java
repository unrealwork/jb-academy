package animals.tree.stats;

public interface Statistic {
    default String getAsString() {
        return get().toString();
    }
    Object get();
}
