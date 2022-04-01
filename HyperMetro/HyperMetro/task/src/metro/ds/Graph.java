package metro.ds;

import java.util.Collection;

public interface Graph<U> {
    boolean isAdjacent(U u, U v);

    Collection<U> neighbors(U u);

    void addNode(U u);

    void removeNode(U u);

    void addEdge(U u, U v);

    void removeEdge(U u, U v);

    static <T> Graph<T> directed() {
        return new AdjacencyListsGraph<>();
    }
}
