/*Given an integer n, return a spiral array of n * n sizes.
 * Given n = 3
	the spiral array is:
	[
	[1,2,3]
	[8,9,4]
	[7,6,5]
	]
	
Hint: change the filling in direction
*/

public class spiralArray {

	public static void main(String[] args) {
		System.out.println(spiralArray(5));
	}
	
	public static int[][] spiralArray(int n) {
		int res[][] = new int[n][n];
		
		//***HINT***
		//Direction: 
		int[] dx = new int[]{0, 1, 0, -1}; //row
		int[] dy = new int[]{1, 0, -1, 0}; //column
		//current: x,y
		//d: direction
		//next grid: (x+dx[d], y+dy[d])
		
		//initial
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				res[i][j] = -1; //-1 indicates that [i][j] not been filled in yet
			}
		}
		
		int x=0;
		int y=0;
		int d=0;
		int nx, ny; //d: filling in the matrix in d direction
		for(int i=1; i<=n*n; i++){
			res[x][y] = i;
			
			//check next x and y, whether it's fall outside matrix
			nx = x + dx[d];
			ny = y + dy[d];
			
			//rotate(change d) if it's outside the matrix or it already been filled
			if(nx < 0 || nx >= n || ny < 0 || ny >= n || res[nx][ny] != -1){
				d = (d + 1) % 4;
				nx = x + dx[d];
				ny = y + dy[d];
			}
			
			x = nx;
			y = ny;
		}
		return res;
    }

}
