package Matrix;
import java.util.ArrayList;
import java.util.List;

/*Given two Sparse Matrix A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example
A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 * */
public class SparseMatrixMultiplication {

	public static void main(String[] args) {
		

	}

	/**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
		int n = A.length; //A's row number
		int m = B[0].length; //B's column number
		int t = A[0].length; //A's column number = B's row number
		int[][] res = new int[n][m];
		
		//Get all the non-zero element in B
		List<List<Integer>> col = new ArrayList<>();
		for(int i=0; i<t; i++) {
			col.add(new ArrayList<>()); //col.size = B's row number
			for(int j=0; j<m; j++) {
				if(B[i][j] != 0) {
					col.get(i).add(j);
				}
			}
		}
		//col: {{0},{},{2}} , contains the position info of non-zero element in B
		
		//Iterate A, if element is non-zero, do the calculation
		//Multiply and sum the corresponding col in B(look up in col)
		for(int i=0; i<n; i++) {
			for(int k=0; k<t; k++) {
				if(A[i][k] != 0) {
					for(int p=0; p<col.get(k).size(); p++) {
						int j=col.get(k).get(p);
						res[i][j] += A[i][k] * B[k][j];
					}
				}
			}
		}
    	return res;
    }
}
