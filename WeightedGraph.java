import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    final Map<T, Vertex<T>> map = new HashMap<>();

    public WeightedGraph() {
        this(false);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T v) {
        if (hasVertex(v))
            return;

        map.put(v, new Vertex<>(v));
    }

    public void addEdge(T source, T dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (map.get(source).contains(map.get(dest))
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(map.get(dest), weight);

        if (undirected)
            map.get(dest).add(map.get(source), weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<T> v : map.values()) {
            count += v.adjacencyList().size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;

        return map.get(source).contains(map.get(dest));
    }

    public Double getWeight(T source, T dest){
        return map.get(source).getWeightTo(map.get(dest));
    }

    public List<T> adjacencyList(T v) {
        if (!hasVertex(v)) return null;

        return map.get(v).adjacencyList();
    }

    public Iterable<Vertex<T>> getEdges(T v) {
        if (!hasVertex(v)) return null;

        return map.get(v).getNeighbors();
    }
}
