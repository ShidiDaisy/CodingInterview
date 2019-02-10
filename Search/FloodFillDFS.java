package Search;

import java.util.Arrays;

public class FloodFillDFS {

	//8 possible movement
	private static final int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static final int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};
	
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
	
	private static void floodFill(char[][] M, int x, int y, char replacement) {
		int m = M.length;
		int n = M[0].length;
		char target = M[x][y];
		M[x][y] = replacement;
		
		//Recursively replace the color
		for(int i=0; i<8; i++) {
			int nextX = x + row[i];
			int nextY = y + col[i];
			if(isValid(M, m, n, nextX, nextY, target)) {
				floodFill(M, nextX, nextY, replacement);
			}
		}
	}

	/**
	 * params: 
	 * m: width of M
	 * n: width of M
	 * to (x, y)
	 * */
	public static boolean isValid(char[][] M, int m, int n, int x, int y, char target) {
		return x>=0 && x<m && y>=0 && y<n && M[x][y] == target ;
	}

}
