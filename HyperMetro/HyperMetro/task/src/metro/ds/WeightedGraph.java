package metro.ds;

import java.util.Objects;

public interface WeightedGraph<V> extends Graph<V> {
    int weight(V from, V to);

    void addEdge(V v, V v2, int weight);

    @Override
    default void addEdge(V v, V v2) {
        if (!Objects.equals(v, v2)) {
            addEdge(v, v2, 1);
        }
    }
}
