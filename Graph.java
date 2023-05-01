import java.util.*;
    public class Graph {
        private Map<String, Node> nodes;

        public Graph() {
            nodes = new HashMap<>();
        }

        public void addNode(String label) {
            nodes.put(label, new Node(label));
        }

        public void addEdge(String label1, String label2, int weight) {
            Node node1 = nodes.get(label1);
            Node node2 = nodes.get(label2);
            node1.link(node2, weight);
        }

        public void dijkstra(String source) {
            Node start = nodes.get(source);
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
            start.weight = 0;
            pq.offer(start);

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                for (Map.Entry<Node, Integer> neighbor : current.links.entrySet()) {
                    Node node = neighbor.getKey();
                    int weight = neighbor.getValue();
                    int distance = current.weight + weight;
                    if (distance < node.weight) {
                        pq.remove(node);
                        node.weight = distance;
                        node.prev = current;
                        pq.offer(node);
                    }
                }
            }

            for (Node node : nodes.values()) {
                System.out.println("Distanza minima da" + source + " a " + node.label + " è " + node.weight);
                System.out.println("Percorso fatto:" + node.getPath());
            }
        }
    }