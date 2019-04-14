package Search;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {
    //adjacency list
    List<List<Integer>> adjList = null;

    /*Constructor:
     * edges in the graph
     * n vertices in the graph*/
    DirectedGraph(List<Edge> edges, int n){
        adjList = new ArrayList<>(n);

        for(int i=0; i<n; i++) {
			/*i: index, vertex
			element*/
            adjList.add(i, new ArrayList<>());
        }

        for(int i=0; i<edges.size(); i++) {
            int src = edges.get(i).source;
            int dest = edges.get(i).destination;

            adjList.get(src).add(dest);
        }
    }
}
