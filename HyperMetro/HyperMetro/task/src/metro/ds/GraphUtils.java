package metro.ds;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
}
