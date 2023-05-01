import java.util.*;

public class Node {
    private int MAX_VALUE = 100;
    String label;
    int weight = MAX_VALUE;
    TreeMap<Node, Integer> links;
    Node prev = null;

    public Node(String label) {
        this.label = label;
        links = new TreeMap<>((a, b) -> a.label.compareTo(b.label));
    }
    public void link(Node nodo2, Integer weight) {
        links.put(nodo2, weight);
        nodo2.links.put(this, weight);
    }
    public int weightTo(Node n) {
        return weight + links.get(n);
    }
    public String getPath() {
        String weight = "";
        if (this.weight < MAX_VALUE)
            weight += this.weight;
        else
            weight = "inf";
        String out = "(" + label + "-" + weight + ")";
        if (prev != null)
            out = prev.getPath() + "-" + prev.links.get(this) + "->" + out;
        return out;
    }
    }