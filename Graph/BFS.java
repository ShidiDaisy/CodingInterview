package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Edge {
	int source, destination;
	
	public Edge(int source, int destination) {
		this.source = source;
		this.destination = destination;
	}
}

class Graph{
	//undirected graph
	//adjacency list
	List<List<Integer>> adjList = null;
	
	/*Constructor: 
	 * edges in the graph
	 * n vertices in the graph*/
	Graph(List<Edge> edges, int n){
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
			adjList.get(dest).add(src);
		}
	}
}
public class BFS {

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
					new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), 
					new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
					new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
					new Edge(7, 11), new Edge(7, 12)
				);
		
		//Number of vertices in the graph
		final int N = 15;
		Graph graph = new Graph(edges, N);
		boolean[] discovered = new boolean[N];
		
		for(int i=0; i<N; i++) {
			if(discovered[i] == false) {
				BFS(graph, i, discovered);
			}
		}
	}
	
	//Starting from vertex v
	public static void BFS(Graph graph, int v, boolean[] discovered) {
		Queue<Integer> q = new ArrayDeque<>();
		
		//mark source vertex is visited
		discovered[v] = true;
		q.add(v);
		
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.println(v + " ");
			
			//add all the connected vertice u of v to q
			for(int u:graph.adjList.get(v)) {
				if(!discovered[u]) {
					discovered[u] = true;
					q.add(u);
				}
			}
		}
	}

}
