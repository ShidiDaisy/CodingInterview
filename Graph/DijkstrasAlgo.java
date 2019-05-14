package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

	public static void main(String[] args) {
		List<EdgeWithWeight> edges = Arrays.asList(
				new EdgeWithWeight(0, 1, 10), new EdgeWithWeight(0, 4, 3),
				new EdgeWithWeight(1, 2, 2), new EdgeWithWeight(1, 4, 4),
				new EdgeWithWeight(2, 3, 9), new EdgeWithWeight(3, 2, 7),
				new EdgeWithWeight(4, 1, 1), new EdgeWithWeight(4, 2, 8),
				new EdgeWithWeight(4, 3, 2)
		);

		// Set number of vertices in the graph
		final int N = 5;

		// construct graph
		DirectedWeightGraph graph = new DirectedWeightGraph(edges, N);

		dijkstra(graph, 0, N);

	}
	/*
	 * n: n vertices in the graph**/
	public static void dijkstra(DirectedWeightGraph graph, int source, int n) {
		//Initiate the distance from every v to source
		List<Integer> dist = new ArrayList<Integer>(Collections.nCopies(n, Integer.MAX_VALUE));
		dist.set(source, 0);
		
		//PriorityQueue store the element with lower weight in front
		PriorityQueue<Node2> minHeap = new PriorityQueue<Node2>(
				(left, right) -> left.weight - right.weight);
		minHeap.add(new Node2(source, 0));
		
		//track the visited node
		boolean[] visited = new boolean[n];
		visited[0] = true;
		
		//store the processor of a vertex
		int prev[] = new int[n];
		prev[0] = -1;
		
		while(!minHeap.isEmpty()) {
			Node2 nodeU = minHeap.poll();
			int u = nodeU.vertex;
			for(EdgeWithWeight edge:graph.adjList.get(u)) {
				int weight = edge.weight;
				int v = edge.dest;
				if(!visited[v] && dist.get(u)+weight < dist.get(v)) {
					dist.set(v, dist.get(u) + weight);
					prev[v] = u;
					minHeap.add(new Node2(v, dist.get(v)));
				}
			}
			visited[u] = true;
		}
		
		//print the result
		for(int i=1; i<n; ++i) {
			System.out.print("Path from vertex 0 to vertex " + i + " has minimum cost of " + dist.get(i) + " and "
					+ "the route is [ ");
			printRoute(prev, i);
			System.out.print("]\n");
			
		}
	}
	
	private static void printRoute(int prev[], int i) {
		if(i < 0) {
			return;
		}
		printRoute(prev, prev[i]);
		System.out.print(i + " ");
	}

}
