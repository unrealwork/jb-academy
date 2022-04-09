package metro.ds;

import java.util.Collection;
import java.util.Set;

public interface Graph<U> {
    boolean isAdjacent(U u, U v);

    Collection<U> neighbors(U u);

    void addNode(U u);

    void removeNode(U u);

    void addEdge(U u, U v);

    void removeEdge(U u, U v);

    Set<U> nodes();

    static <T> WeightedGraph<T> directed() {
        return new AdjacencyListsGraph<>();
    }
}
