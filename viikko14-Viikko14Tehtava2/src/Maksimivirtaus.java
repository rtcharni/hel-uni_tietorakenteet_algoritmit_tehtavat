import com.scerra.graphs.Node;

import java.util.*;

public class Maksimivirtaus {     
    int n;
    com.scerra.graphs.Graph graph;
    Node[] arr;

    public Maksimivirtaus(int n) {
        this.n = n;
        this.graph = (com.scerra.graphs.Graph) new com.scerra.graphs.FlowGraph();
        arr = new com.scerra.graphs.Node[n];
        Node first = new Node(0, Integer.toString(0));
        arr[0] = first;
        graph.addNode(first);
        graph.setSource(first);

        for (int i = 1; i < n; i++) {
            Node nn = new Node(i, Integer.toString(i));
            graph.addNode(nn);
            arr[i] = nn;
            if (i == n-1) {
                graph.setSink(nn);
            }
        }

    }

    public void lisaaKaari(int a, int b, int p) {
        graph.addEdge(new com.scerra.graphs.Edge(arr[a-1], arr[b-1], p));
    }
    
    
    public int laske() {
        double f = com.scerra.graphs.algorithms.MaxFlowCalculator.getMaxFlow(this.graph);
        return (int)f;
    }    
}
