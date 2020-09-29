package DP;
/**
 * Leetcode 62 Unique Paths https://leetcode.com/problems/unique-paths/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?*/
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        //1. 开数组
        int[][] f = new int[m][n];

        //2. loop from initial state
        for(int i=0; i<m; i++){ //row
            for(int j=0; j<n; j++){ //column

                //3. 边界条件
                if (i == 0 || j == 0){
                    f[i][j] = 1;
                }else{
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }

        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
}
