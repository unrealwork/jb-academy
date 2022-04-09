package metro.ds;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GraphUtils {
    private GraphUtils() {

    }

    public static <T> List<T> shortestPath(Graph<T> graph, T u, T v) {
        Queue<T> queue = new ArrayDeque<>();
        Map<T, List<T>> paths = new HashMap<>();
        queue.add(u);
        paths.put(u, Collections.singletonList(u));
        while (!queue.isEmpty() && !paths.containsKey(v)) {
            T el = queue.remove();
            Collection<T> neighbors = graph.neighbors(el);
            List<T> pathToNode = paths.get(el);
            for (T neighbor : neighbors) {
                if (!paths.containsKey(neighbor)) {
                    queue.add(neighbor);
                    List<T> pathToNeighbor = new ArrayList<>(pathToNode);
                    pathToNeighbor.add(neighbor);
                    paths.put(neighbor, Collections.unmodifiableList(pathToNeighbor));
                }
            }
        }
        return paths.get(v);
    }

    public static <T> WeightedPath<T> fastestPath(WeightedGraph<T> wGraph, T start, T end) {
        final Map<T, List<T>> paths = new HashMap<>();
        List<T> path = new ArrayList<>();
        path.add(start);
        paths.put(start, path);
        Map<T, Integer> distMap = new HashMap<>();
        Set<T> nodes = wGraph.nodes();
        for (T node : nodes) {
            distMap.put(node, node.equals(start) ? 0 : Integer.MAX_VALUE);
        }
        Comparator<T> comp = Comparator.comparingInt(distMap::get);
        final PriorityQueue<T> pq = new PriorityQueue<>(comp);
        pq.addAll(nodes);
        while (distMap.containsKey(end)) {
            T nearest = pq.remove();
            int dist = distMap.remove(nearest);
            if (nearest.equals(end)) {
                return WeightedPath.create(paths.get(end), dist);
            }
            for (T neighbor : wGraph.neighbors(nearest)) {
                int newDist = wGraph.weight(nearest, neighbor) + dist;
                Integer oldDist = distMap.get(neighbor);
                if (oldDist != null && oldDist > newDist) {
                    distMap.put(neighbor, newDist);
                    final List<T> p = paths.get(nearest);
                    pq.remove(neighbor);
                    pq.add(neighbor);
                    paths.put(neighbor, append(p, neighbor));
                }
            }
        }
        throw new IllegalStateException("Route doesn't exist");
    }

    private static <T> List<T> append(List<T> list, T el) {
        final List<T> res = new ArrayList<>(list);
        res.add(el);
        return Collections.unmodifiableList(res);
    }
}
