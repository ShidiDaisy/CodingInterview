package DP;
/*221. Maximal Square
* Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
* https://leetcode.com/problems/maximal-square/
https://www.jiuzhang.com/problem/maximal-square/#tag-lang-java
https://www.youtube.com/watch?v=fA5dTfzMCew
 */

public class MaxSquare {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                            {'1', '0', '1', '1', '1'},
                            {'1', '1', '1', '1', '1'},
                            {'1', '0', '0', '1', '0'}};
        char[][] matrix1 = {};
        char[][] matrix2 = {{'1'}};
        char[][] matrix3 = {{'0','1'}};
        MaxSquare ms = new MaxSquare();
        System.out.println(ms.maximalSquare(matrix3));
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m;
        int ans = 0;

        if(n > 0){
            m = matrix[0].length;
        }else{
           return ans;
        }

        int[][] dp = new int [n][m];

        for(int j=0; j<m; j++){

        }

        for(int i=0; i<n; i++){
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            ans = Math.max(dp[i][0] , ans);
            for(int j=1; j<m; j++){
                if(i > 0){
                    if(matrix[i][j] == '0'){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                }else{
                    dp[0][j] = Character.getNumericValue(matrix[0][j]);
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans*ans;
    }
}
