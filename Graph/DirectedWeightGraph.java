package Graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedWeightGraph {
	List<List<EdgeWithWeight>> adjList = null;
	DirectedWeightGraph(List<EdgeWithWeight> edges, int N){
		adjList = new ArrayList<>(N);
		for(int i=0; i<N; i++) {
			adjList.add(i, new ArrayList<>());
		}
		
		for(EdgeWithWeight edge:edges) {
			adjList.get(edge.src).add(edge);
		}
	}
}
