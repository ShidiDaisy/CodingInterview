package Matrix;
import java.util.LinkedList;
import java.util.Queue;

/*Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
input:

[
[0,0,0],
[0,1,0],
[1,1,1]
]
output:

[
[0,0,0],
[0,1,0],
[1,2,1]
]

Hint: BreathFirstSearch
建立Pair类来进行辅助，
1. 将所有非0行列元素变为Integer.MAX_VALUE
2. 将0放入queue中
3. 然后通过队列里存的0，将4周的元素，如果小于cur = queue.poll(), 则cur＋＋，并放入queue中。
*/
class Pair{
	int x;
	int y;
	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Matrix01 {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{0,0,0},
									{0,1,0},
									{1,1,1}};
		System.out.println(updateMatrix(matrix));
	}
	
	/**
     * @param matrix: a 0-1 matrix
     * @return: return a matrix
     */
    public static int[][] updateMatrix(int[][] matrix) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return new int[0][0];
        }
        
        //Loop the matrix, put all the 0 into Queue
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i=0; i<matrix[0].length; i++){
        	for(int j=0; j<matrix.length; j++){
        		if(matrix[i][j] == 0){
        			queue.offer(new Pair(i, j));
        		}else{
        			matrix[i][j] = Integer.MAX_VALUE;
        		}
        	}
        }
        
        //Interate the element in queue
        while(!queue.isEmpty()){
        	Pair cur = queue.poll();
        	
        	//get the elements around cur
        	int x = cur.x;
        	int y = cur.y;
        	for(int i=0; i<4; i++){
        		int nextX = x + dx[i];
        		int nextY = y + dy[i];
        		if(nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix[0].length){
        			continue;
        		}else{
        			//if it's value > cur
        			if(matrix[x][y] < matrix[nextX][nextY]){
        				matrix[nextX][nextY] = matrix[x][y] + 1;
        				queue.offer(new Pair(nextX, nextY));//add to queue
        			}
        		}
        	}
        }
    	
    	return matrix;   
    }

}
