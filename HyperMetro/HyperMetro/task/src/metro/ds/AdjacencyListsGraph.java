package metro.ds;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class AdjacencyListsGraph<U> implements WeightedGraph<U> {
    private final Map<U, Map<U, Integer>> adjacencyList = new HashMap<>();

    @Override
    public boolean isAdjacent(U u, U v) {
        return adjacencyList.containsKey(u)
                && adjacencyList.get(u).containsKey(v);
    }

    @Override
    public Collection<U> neighbors(U u) {
        return adjacencyList.getOrDefault(u, Collections.emptyMap())
                .keySet();
    }

    @Override
    public void addNode(U u) {
        adjacencyList.putIfAbsent(u, new HashMap<>());
    }

    @Override
    public void removeNode(U u) {
        adjacencyList.remove(u);
    }

    @Override
    public int weight(U from, U to) {
        if (from.equals(to)) {
            return 0;
        }
        return isAdjacent(from, to) ? adjacencyList.get(from).get(to) : Integer.MAX_VALUE;
    }

    @Override
    public void addEdge(U u, U v2, int weight) {
        addNode(u);
        addNode(v2);
        adjacencyList.computeIfPresent(u, (u1, us) -> {
            us.put(v2, weight);
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

    @Override
    public Set<U> nodes() {
        return Collections.unmodifiableSet(adjacencyList.keySet());
    }
}
