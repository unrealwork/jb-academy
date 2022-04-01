package metro.ds;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class AdjacencyListsGraph<U> implements Graph<U> {
    private final Map<U, Set<U>> adjacencyList = new HashMap<>();

    @Override
    public boolean isAdjacent(U u, U v) {
        return adjacencyList.containsKey(u) && adjacencyList.get(u)
                .contains(v);
    }

    @Override
    public Collection<U> neighbors(U u) {
        return Collections.unmodifiableSet(
                adjacencyList.getOrDefault(u, Collections.emptySet()));
    }

    @Override
    public void addNode(U u) {
        adjacencyList.putIfAbsent(u, new LinkedHashSet<>());
    }

    @Override
    public void removeNode(U u) {
        adjacencyList.remove(u);
    }

    @Override
    public void addEdge(U u, U v) {
        addNode(u);
        addNode(v);
        adjacencyList.computeIfPresent(u, (u1, us) -> {
            us.add(v);
            return us;
        });
    }

    @Override
    public void removeEdge(U u, U v) {
        adjacencyList.computeIfPresent(u, (u1, us) -> {
            us.remove(v);
            return us;
        });
    }
}
