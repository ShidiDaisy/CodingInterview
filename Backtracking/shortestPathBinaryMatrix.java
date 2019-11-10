package Backtracking;
/*Leetcode 1091
* In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
*
* Hint:
* 1. To search the shortest path in maze, we search for all possible paths in the maze from starting point to end point until all
* possibilities are exhausted by backtracking.
*   - Track the cells that involved in current path, ignore the cell if it's already in the current path
*   - If a path doesn't lead to the destination or we have explored all possible routes from current cell, we backtrack
* 2. We update the minimum path length whenever destination cell is reached
*
* 8 movements:
* top left: (x-1, y-1)
* top: (x, y-1),
* top right: (x+1, y-1)
* left: (x-1, y)
* right: (x+1, y)
* bottom left: (x-1, y+1)
* bottom: (x, y+1)
* bottom right: (x+1, y+1)
* */

public class shortestPathBinaryMatrix {
    public static boolean findTheWay = false;
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0,1},{1,0,0,0,0},{0,1,0,1,0},{0,0,0,1,1},{0,0,0,1,0}};
        int[][] grid2 = {{0,1},{1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        int[][] visited = new int[N][N];

        if(grid[0][0] == 1 || grid[N-1][N-1] == 1){
            return -1;
        }else {
            return findShortestPath(Integer.MAX_VALUE, 1, 0, 0, N, visited, grid);
        }
    }

    /*Check if it is possible to go (x, y), return false if cell contains 1 or already visited*/
    public static boolean isSafe(int[][] grid, int[][] visited, int x, int y){
        return (grid[x][y] == 0) && (visited[x][y] == 0);
    }

    /*Check if it is a valid position*/
    public static boolean isValid(int x, int y, int N){
        return (x < N && y < N && x >= 0 && y >= 0);
    }

    public static int findShortestPath(int minDist, int dist, int x, int y, int N, int[][] visited, int[][] grid){
        //if destination is found, update shortest length
        if(x == N-1 && y == N-1){
            findTheWay = true;
            return Integer.min(minDist, dist);
        }

        // set this cell is visited
        visited[x][y] = 1;

        // go to top left cell
        if(isValid(x-1, y-1, N) && isSafe(grid, visited, x-1, y-1)){
            minDist = findShortestPath(minDist, dist+1, x-1, y-1, N, visited, grid);
        }

        if(isValid(x, y-1, N) && isSafe(grid, visited, x, y-1)){
            minDist = findShortestPath(minDist, dist+1, x, y-1, N, visited, grid);
        }

        if(isValid(x+1, y-1, N) && isSafe(grid, visited, x+1, y-1)){
            minDist = findShortestPath(minDist, dist+1, x+1, y-1, N, visited, grid);
        }

        if(isValid(x-1, y, N) && isSafe(grid, visited, x-1, y)){
            minDist = findShortestPath(minDist, dist+1, x-1, y, N, visited, grid);
        }

        if(isValid(x+1, y, N) && isSafe(grid, visited, x+1, y)){
            minDist = findShortestPath(minDist, dist+1, x+1, y, N, visited, grid);
        }

        if(isValid(x-1, y+1, N) && isSafe(grid, visited, x-1, y+1)){
            minDist = findShortestPath(minDist, dist+1, x-1, y+1, N, visited, grid);
        }

        if(isValid(x, y+1, N) && isSafe(grid, visited, x, y+1)){
            minDist = findShortestPath(minDist, dist+1, x, y+1, N, visited, grid);
        }

        if(isValid(x+1, y+1, N) && isSafe(grid, visited, x+1, y+1)){
            minDist = findShortestPath(minDist, dist+1, x+1, y+1, N, visited, grid);
        }

        //backtrack to last block
        visited[x][y] = 0;
        if(findTheWay == false){
            //if cannot find the way -> back to original point
            return -1;
        }else {
            return minDist;
        }
    }
}
