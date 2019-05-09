package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*Given a maze in the form of the binary rectangular matrix, find length of the shortest path in a maze
 * from give source to given destination
 * 
 * The path can only be constructed out of cells having value 1 and at any given moment, we can only
 * move one step in one of the four directions
 * 
 * Lee Algorithm (based on BFS)
 * 1. Create an empty queue and enqueue source cell having distance 0 from source and mark it as visited
 * 2. do till queue is empty
 * 		a. Pop front node from the queue
 * 		b. If the popped node is destination node, than return its distance
 * 		c. else: for each of 4 adjacent cells of current cell, we enqueue each unvisited cell into the queue with +1 distance
 * and mark them as visited
 * 3. If all the nodes in the queue is processed and destination is not reached, then return false
 * */
class Node{
	int x, y, dist;
	Node(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class LeeAlgorithm {
	//Define an M*N matrix
	private static final int M = 10;
	private static final int N = 10;
	
	//Define movement: Up, Right, Down, Left
	private static final int row[] = {-1, 0, 1, 0};
	private static final int column[] = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		//Maze
		int[][] mat = {
				{1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
				{0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
				{0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
				{1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
				{0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
				{1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
				{0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
				{0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
				{1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
				{0, 0, 1, 0, 0, 1, 1, 0, 0, 1}
		};
		
		//Find shortest path from source(0, 0) to (7, 5)
		int min_dist = BFS(mat, 0, 0, 7, 5);
		if(min_dist == Integer.MAX_VALUE) {
			System.out.println("Destination can't be reached");
		}else {
			System.out.println("The shortest path from source to destination has length: " + min_dist);
		}
	}

	
	//Check if it's possible to go to position (row, col)
	private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
		if(row>=0 && row<M && col >= 0 && col < N && mat[row][col] == 1 && !visited[row][col]) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * i, j: source coordinates
	 * x, y: destination coordinates*/
	private static int BFS(int mat[][], int i, int j, int x, int y) {
		boolean[][] visited = new boolean[M][N];
		Queue<Node> q = new LinkedList<>();
		int min_dist = Integer.MAX_VALUE;
		
		//mark current cell is visited
		visited[i][j] = true;
		q.add(new Node(i, j, 0));
		
		while(!q.isEmpty()) {
			//If the popped node is destination node, than return its distance
			Node node = q.poll(); //current node
			i = node.x;
			j = node.y;
			int dist = node.dist;
			
			if(i == x && j == y) {
				min_dist = dist;
			}else {
				//for each of 4 adjacent cells of current cell, we enqueue each unvisited cell into the queue with +1 distance
				 //and mark them as visited
				for(int k=0; k<4; k++) {
					//check whether is valid access node or not
					int nextX = i+row[k];
					int nextY = j+column[k];
					if(isValid(mat, visited, nextX, nextY)) {
						//enqueue
						q.add(new Node(nextX, nextY, dist+1));
						visited[nextX][nextY] = true;
					}
				}
			}
		}
		return min_dist;
	}

}
