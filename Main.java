public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 3);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);

        graph.dijkstra("A");
    }
}