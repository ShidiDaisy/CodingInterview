package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*The flood-fill algorithm takes three parameters
 * 		- start node
 * 		- target color (at the start node connected area)
 * 		- replacement color
 * 
 * 	Approach 1: BFS (starting-pixel, replacement color)
 * 1. Create an empty queue
 * 2. Enqueue starting pixel
 * 3. Do till queue is empty
 * 		a). Pop front node from the queue
 * 		b). Replace color of current pixel with replacement color
 * 		c). Process all 8 adjacent pixels of current pixel and enqueue each valid pixel with the same color.
 * 
 *No need to keep track of the visited node, cause we will only visited the node with same color as source node,
 *visited node already changed to replacement color.
 * */
class Pair{
	int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class FloodFillBFS {

	public static void main(String[] args) {
		char[][] M = {
				"YYYGGGGGGG".toCharArray(),
				"YYYYYYGXXX".toCharArray(),
				"GGGGGGGXXX".toCharArray(),
				"WWWWWGGGGX".toCharArray(),
				"WRRRRRGXXX".toCharArray(),
				"WWWRRGGXXX".toCharArray(),
				"WBWRRRRRRX".toCharArray(),
				"WBBBBRRXXX".toCharArray(),
				"WBBXBBBBXX".toCharArray(),
				"WBBXXXXXXX".toCharArray()
		};
		
		//start node:
		int x = 3;
		int y = 9;
		
		//replacement color
		char replacement = 'C';
		
		floodFill(M, x, y, replacement);
		
		for(int i=0; i<M.length; i++) {
			System.out.println(Arrays.toString(M[i]));
		}
	}
	
	//8 possible movement
	private static final int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static final int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	/**
	 * params: 
	 * m: width of M
	 * n: width of M
	 * to (x, y)
	 * */
	public static boolean isValid(char[][] M, int m, int n, int x, int y, char target) {
		return x>=0 && x<m && y>=0 && y<n && M[x][y] == target ;
	}
	
	/**
	 * x, y: coordinates of current node
	 * */
	public static void floodFill(char[][] M, int x, int y, char replacement) {
		int m = M.length;
		int n = M[0].length;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		char target = M[x][y]; //get source color
		
		while(!q.isEmpty()) {
			//Pop front node from the queue
			Pair currentNode = q.poll();
			x = currentNode.x;
			y = currentNode.y;
			
			//Replace color of current pixel with replacement color
			M[x][y] = replacement;
			
			//Process all 8 adjacent pixels of current pixel
			for(int i=0; i<8; i++) {
				int nextX = x + row[i];
				int nextY = y + col[i];
				
				//enqueue each valid pixel with the same color
				if(isValid(M, m, n, nextX, nextY, target)) {
					q.add(new Pair(nextX, nextY));
				}
			}
		}
	}

}
