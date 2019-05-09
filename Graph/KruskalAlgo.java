package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Find the minimal spanning tree in undirected graph
public class KruskalAlgo {
	public static void main(String[] args) {
		List<EdgeWithWeight> edges = Arrays.asList(new EdgeWithWeight(0, 1, 7), new EdgeWithWeight(1, 2, 8),
				new EdgeWithWeight(0, 3, 5), new EdgeWithWeight(1, 3, 9),
				new EdgeWithWeight(1, 4, 7), new EdgeWithWeight(2, 4, 5),
				new EdgeWithWeight(3, 4, 15), new EdgeWithWeight(3, 5, 6),
				new EdgeWithWeight(4, 5, 8), new EdgeWithWeight(4, 6, 9),
				new EdgeWithWeight(5, 6, 11));
		
		//1. Sort all edges in the graph G in the orders of their increasing weights
		Collections.sort(edges, (a, b) -> a.weight - b.weight);
		
		final int N = 7; //number of vertices in the graph
		List<EdgeWithWeight> e = kruskalAlgo(edges, N);
		
		for(EdgeWithWeight edge:e) {
			System.out.println(edge);
		}

	}
	
	
	

	//2. Repeat V-1 time (MST contains v-1 edges)
		//2.1 Select the next edge with minimum weight from the graph G
		//2.2 if no cycle is formed by adding the edge in MST (No edge connected two components that already in MST)
			//2.2.1 Add the edge to MST
	
	public static List<EdgeWithWeight> kruskalAlgo(List<EdgeWithWeight> edges, int N) {
		List<EdgeWithWeight> MST = new ArrayList<EdgeWithWeight>();
		
		//for each vertex v belonging G.V -> Make-Set(v)
		DisjointSet ds = new DisjointSet();
		ds.makeSet(N);
		
		//MST contain exactly N-1 edges
		int i = 0;
		while(MST.size() != N-1) { //MST not complete yet
			//for each (u->v), if u's set != v's set
			int u = edges.get(i).src;
			int v = edges.get(i).dest;
			
			if(ds.findSet(u) != ds.findSet(v)) {
				//not in the same set -> not connected
				//add(u->v) to set MST
				MST.add(edges.get(i));
				
				//Union(u->v)
				ds.union(u, v);
			}
			i++;
		}
		return MST;
	}
}

class DisjointSet{
	//<SetNum, VertexNum>
	Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
	
	//Create singleton set
	public void makeSet(int N) {
		for(int i=0; i<N; i++) {
			parent.put(i, i);
		}
	}
	
	public int findSet(int vertex) {
		//root
		if(parent.get(vertex) == vertex) {
			return vertex;
		}
		
		//if not, recursively go up to find the root (set num)
		return findSet(parent.get(vertex));
	}
	
	public void union(int a, int b) {
		//find the root of the set that a, b belongs to
		parent.put(findSet(a), findSet(b));
	}
}
