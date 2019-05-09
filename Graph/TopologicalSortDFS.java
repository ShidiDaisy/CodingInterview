package Graph;

import java.util.Arrays;
import java.util.List;

/*
https://www.techiedelight.com/topological-sorting-dag/

Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

You can assume that there is at least one topological order in the graph.*/
//class Edge, Graph are defined in BFS.java
public class TopologicalSortDFS {
    public static void main(String[] args){
        List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
        );

        //number of vertices in the graph
        final int N = 8;

        DirectedGraph graph = new DirectedGraph(edges, N);
        doTopologicalSort(graph, N);

    }

    public static void doTopologicalSort(DirectedGraph graph, int N){

        //stores the vertex number using departure time as vertex
        int[] departure = new int[2*N];
        Arrays.fill(departure, -1);

        //stores vertex is visited or not
        boolean[] discovered = new boolean[N];

        //DFS on all undiscovered vertices
        int time = 0; //arrival time
        for(int i=0; i<N; i++){
            if(!discovered[i]){
                time = DFS(graph, i, discovered, time, departure);
            }
        }

        //print the vertices in order of their decreasing departure time  (topological order)
        for(int i=2*N-1; i >= 0; i--){
            if(departure[i] != -1){
                System.out.println(departure[i] + " ");
            }
        }
    }

    /**
     * params:
     * v: current vertex*/
    public static int DFS(DirectedGraph graph, int v, boolean[] discovered, int time, int[] departure){
        discovered[v] = true;
        time ++;

        //for every edge v->u, perform DFS
        for(int u:graph.adjList.get(v)){
            if(!discovered[u]){
                time = DFS(graph, u, discovered, time, departure);
            }
        }

        //backtrack
        //set departure time of v
        departure[time] = v;
        time++;

        return time;
    }
}
