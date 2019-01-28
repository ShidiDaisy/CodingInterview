package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//class Edge, Graph are defined in BFS.java
/*class Edge {
	int source, destination;
	
	public Edge(int source, int destination) {
		this.source = source;
		this.destination = destination;
	}
}
*/
/*class Graph{
	//adjacency list
	List<List<Integer>> adjList = null;
	
	Constructor: 
	 * edges in the graph
	 * n vertices in the graph
	Graph(List<Edge> edges, int n){
		adjList = new ArrayList<>(n);
		
		for(int i=0; i<n; i++) {
			i: index, vertex
			element
			adjList.add(i, new ArrayList<>());
		}
		
		for(int i=0; i<edges.size(); i++) {
			int src = edges.get(i).source;
			int dest = edges.get(i).destination;
			
			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
	}
}*/

public class DFS {

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
				new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
				new Edge(3, 5), new Edge(8, 9), new Edge(8, 12), new Edge(9, 10), new Edge(9, 11));
		
		final int N = 13;
		Graph graph =  new Graph(edges, N);
		boolean[] discovered = new boolean[N];
		
		for(int i=0; i<N; i++) {
			if(!discovered[i]) {
				DFS(graph, i, discovered);
			}
		}
	}
	
	/*
	 * v: current node
	 * */
	public static void DFS(Graph graph, int v, boolean[] discovered) {
		discovered[v] = true;
		System.out.print(v + " ");
		
		//u: for every child of v
		for(int u:graph.adjList.get(v)) {
			if(!discovered[u]) {
				discovered[u] = true;
				DFS(graph, u, discovered);
			}
		}
	}

}
