import java.util.*;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data){
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public T getData(){
        return data;
    }

    public boolean contains(Vertex<T> item){
        return adjacentVertices.containsKey(item);
    }

    public List<T> adjacencyList(){
        List<T> list = new LinkedList<>();
        for (Vertex<T> item : adjacentVertices.keySet()){
            list.add(item.data);
        }
        return list;
    }

    public void add(Vertex<T> neighbor, double weight){
        adjacentVertices.put(neighbor, weight);
    }
    public Double getWeightTo(Vertex<T> neighbor){
        return adjacentVertices.get(neighbor);
    }


    public boolean equals(Object object){
        return (object instanceof Vertex<?> something && Objects.equals(this.data, something.data));
    }

    public Iterable<Vertex<T>> getNeighbors() {
        return adjacentVertices.keySet();
    }

    // getters&setters constructors
    // equals
}
