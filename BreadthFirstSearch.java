import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> extends Search<T>{
    public BreadthFirstSearch(UnweightedGraph<T> graph, T source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(UnweightedGraph<T> graph, T current) {
        marked.add(current);


        Queue<T> queue = new LinkedList<>();
        queue.add(current); //[0]

        while (!queue.isEmpty()) {
            T v = queue.remove(); // []

            for (T vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v); // {[1,0] [2,0] [3,0] [4 0] [5 1] [6 1] [7 2]}
                    queue.add(vertex); // [1,2,3,4]
                }
            }
        }
    }
}

