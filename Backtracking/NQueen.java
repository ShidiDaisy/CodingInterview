/*Leetcode 51: N-Queens
* The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
* Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen
* and an empty space respectively.
*
* Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

 */
package Backtracking;
import java.util.ArrayList;
import java.util.List;
class NQueen {
    public static void main(String[] args){
        int N=8;
        List<List<String>> sol = solveNQueens(N);
        for(int i=0; i<sol.size(); i++){
            for (int j=0; j<N; j++){
                System.out.println(sol.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char mat[][] = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = '.';
            }
        }
        //start from row 0
        result = nQueens(mat, n, 0, result);

        return result;
    }

    /*
    * r: row number*/
    public static List<List<String>> nQueens(char[][] mat, int N, int r, List<List<String>> result){
        if (r == N){
            // N queens are placed successfully, add to the solution
            List<String> resList = charToList(mat);
            result.add(resList);
        }

        //Iterate every square in row r
        for(int i=0; i<N; i++){
            if(isSafe(mat, r, i)){
                //place Q in current square
                mat[r][i] = 'Q';

                //into next row
                nQueens(mat, N, r+1, result);

                //backtrack and remove the Q from current place
                mat[r][i] = '.';
            }
        }
        return result;
    }

    public static boolean isSafe(char[][] mat, int r, int c){
        //check so far if two queens share the same column
        for(int i=0; i<r; i++){
            if(mat[i][c] == 'Q'){
                return false;
            }
        }

        //check so far if two queens share \ diagonal
        for(int i = r, j = c; i >= 0 && j>=0; i--, j--){
            if(mat[i][j] == 'Q'){
                return false;
            }
        }

        //check so far if two queens share / diagonal
        for(int i = r, j = c; i >= 0 && j < mat.length; i--, j++){
            if(mat[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static List<String> charToList(char[][] arr){
        List<String> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            String row = new String(arr[i]);
            list.add(row);
        }
        return list;
    }
}