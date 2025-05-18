import java.util.*;

class WeightedGraph {
    List<Vertex> vertices;

    public WeightedGraph() {
        vertices = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void addEdge(Vertex v1, Vertex v2, double weight) {
        v1.addNeighbor(v2, weight);
        v2.addNeighbor(v1, weight);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }
}

abstract class Search {
    Vertex start;
    WeightedGraph graph;

    public Search(WeightedGraph graph, Vertex start) {
        this.graph = graph;
        this.start = start;
    }

    abstract List<Vertex> findPath(Vertex end);

    protected List<Vertex> getPath(Vertex end) {
        List<Vertex> path = new ArrayList<>();
        Vertex current = end;
        while (current != null) {
            path.add(current);
            current = current.previous;
        }
        Collections.reverse(path);
        return path;
    }
}

class BreadthFirstSearch extends Search {
    public BreadthFirstSearch(WeightedGraph graph, Vertex start) {
        super(graph, start);
    }

    @Override
    List<Vertex> findPath(Vertex end) {
        for (Vertex v : graph.getVertices()) {
            v.visited = false;
            v.previous = null;
        }

        Queue<Vertex> queue = new LinkedList<>();
        start.visited = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (current == end) {
                return getPath(end);
            }

            for (Vertex neighbor : current.neighbors.keySet()) {
                if (!neighbor.visited) {
                    neighbor.visited = true;
                    neighbor.previous = current;
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>();
    }
}

class DijkstraSearch extends Search {
    public DijkstraSearch(WeightedGraph graph, Vertex start) {
        super(graph, start);
    }

    @Override
    List<Vertex> findPath(Vertex end) {
        for (Vertex v : graph.getVertices()) {
            v.distance = Double.POSITIVE_INFINITY;
            v.previous = null;
            v.visited = false;
        }

        start.distance = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            if (current == end) {
                return getPath(end);
            }

            if (current.visited) continue;
            current.visited = true;

            for (Map.Entry<Vertex, Double> entry : current.neighbors.entrySet()) {
                Vertex neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = current.distance + weight;

                if (newDist < neighbor.distance) {
                    neighbor.distance = newDist;
                    neighbor.previous = current;
                    pq.add(neighbor);
                }
            }
        }

        return new ArrayList<>();
    }
}