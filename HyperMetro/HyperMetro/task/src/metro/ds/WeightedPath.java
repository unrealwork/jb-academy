package metro.ds;

import java.util.Collections;
import java.util.List;

public class WeightedPath<T> {
    private final List<T> path;
    private final int dist;

    private WeightedPath(List<T> path, int dist) {
        this.path = Collections.unmodifiableList(path);
        this.dist = dist;
    }

    public List<T> getPath() {
        return path;
    }

    public int getDist() {
        return dist;
    }

    public static <T> WeightedPath<T> create(List<T> path, int dist) {
        return new WeightedPath<T>(path, dist);
    }
}
