import java.util.*;

class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);

        graph.addEdge(A, B, 4.0);
        graph.addEdge(A, C, 2.0);
        graph.addEdge(B, D, 3.0);
        graph.addEdge(C, D, 1.0);
        graph.addEdge(D, E, 5.0);

        System.out.println("BFS from A to E:");
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, A);
        List<Vertex> bfsPath = bfs.findPath(E);
        System.out.println(bfsPath);

        System.out.println("Dijkstra from A to E:");
        DijkstraSearch dijkstra = new DijkstraSearch(graph, A);
        List<Vertex> dijkstraPath = dijkstra.findPath(E);
        System.out.println(dijkstraPath);

        System.out.println("Graph has " + graph.getVertices().size() + " vertices");
    }
}