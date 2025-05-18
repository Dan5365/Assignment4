import java.util.*;

class Vertex {
    String name;
    Map<Vertex, Double> neighbors;
    boolean visited;
    double distance;
    Vertex previous;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
        this.visited = false;
        this.distance = Double.POSITIVE_INFINITY;
        this.previous = null;
    }

    public void addNeighbor(Vertex neighbor, double weight) {
        neighbors.put(neighbor, weight);
    }

    public String toString() {
        return name;
    }
}