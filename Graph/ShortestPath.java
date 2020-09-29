package Graph;
/**
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 * https://www.youtube.com/watch?v=EmiGrlCQ-bM&t=796s
 *
 * 1293. Shortest Path in a Grid with Obstacles Elimination
 *  Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step, you can move up, down, left or
 *  right from and to an empty cell.
 *
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m-1, n-1)
 * given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 *
 * Example 1:
 *
 * Input:
 * grid =
 * [[0,0,0],
 *  [1,1,0],
 *  [0,0,0],
 *  [0,1,1],
 *  [0,0,0]],
 * k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2)
 * -> (2,2) -> (3,2) -> (4,2).
 *
 * HINT:
 * 1. BFS
 * 2. add (x, y, k, steps) into a queue
 * 3. Each step:
 *    a. Two possible steps: go up, go down, go left or go right or out of boundary
 *    b. check still have k or not
 *      - if have, can go 1 and 0
 *      - if doesnt have, only go 0
*     c. Should we revisit a node?
 *      - We should if k is larger than the previous k in this block. (Larger k means higher chance to get to the end.)
 *      - To track k, we can use a instance class for each block*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Coordinate{
    int x;
    int y;
    int step;
    int obstacle;

    public Coordinate(int x, int y, int obstacle, int step){
        this.x = x;
        this.y = y;
        this.obstacle = obstacle;
        this.step = step;
    }

    public List<Coordinate> neighbours(int R, int C, int[][] grid){
        List<Coordinate> neighbours = new ArrayList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i=0; i<4; i++){
            int newX = this.x + dx[i];
            int newY = this.y + dy[i];

            if(newX >= 0 && newX < R && newY >= 0 && newY < C){
                //track the obstacle we met
                Coordinate co = new Coordinate(newX, newY, grid[newX][newY] == 1 ? obstacle + 1 : obstacle, step+1 );
                neighbours.add(co);
            }
        }
        return neighbours;
    }
}

class ShortestPath {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},
                        {1,1,0},
                        {0,0,0},
                        {0,1,1},
                        {0,0,0}};

        int[][] grid2 = {{0,1,1},
                        {1,1,1},{1,0,0}};

        int[][] grid3 = {{0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},
                {0,1,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},
                {0,1,0,1,1,1,1,0,0,0},{0,1,0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,0,1,0},{0,0,0,0,0,0,0,0,1,0}};

        int k = 1;
        ShortestPath sp = new ShortestPath();
        System.out.println(sp.shortestPath(grid3, k));
    }

    public int shortestPath(int[][] grid, int k) {

        Queue<Coordinate> q1 = new LinkedList<>();
        int steps = 0;
        int R = grid.length;
        int C = grid[0].length;

        //Initialize visit map
        int[][] visited = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        //add source (upper left corner) to the queue
        Coordinate source = new Coordinate(0, 0, 0, steps);
        q1.offer(source);
        visited[0][0] = 0;

        while (!q1.isEmpty()){
            Coordinate curNode = q1.poll();

            if(curNode.x == R-1 && curNode.y == C-1){
                return curNode.step;
            }

            for(Coordinate c: curNode.neighbours(R, C, grid)){
                if(c.obstacle < visited[c.x][c.y] && c.obstacle <= k){
                    //the obstacles we met must be smaller than k chances and previous step met
                    q1.offer(c);
                    visited[c.x][c.y] = c.obstacle;
                }
            }
        }

        return -1;
    }
}
