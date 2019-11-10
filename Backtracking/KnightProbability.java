package Backtracking;
/*LeetCode 688
* Knight Probability in Chessboard
*
* On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The
* rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal
* direction, then one square in an orthogonal direction.
* Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece
* would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the
* probability that the knight remains on the board after it has stopped moving.
*
* Example:

Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
*
* Hint:
* 1. Start from source square, recursively explore all eight paths possible to check if they lead to a solution or
* not.
* 2. If current path doesn't reach destination or we have explored all possible routes from current square, we
* backtrack.
* 3. Keep track the squares involved in current path in an chessboard and before exploring any square, we ignore
* the square if it is covered in current path to avoid circle.
*
* Eight possible moves that make knight move is circular and optimum
* (x+2, y+1)
* (x+1, y+2)
* (x-1, y+2)
* (x-2, y+1)
* (x-2, y-1)
* (x-1, y-2)
* (x+1, y-2)
* (x+2, y-1)*/

public class KnightProbability {
    public static void main(String[] args){
        System.out.println(knightProbability(8,30,6, 4));
    }
    /*
    * params
    * N: N*N chessboard
    * K: move K steps
    * start at r-th row and c-th column */
    public static double knightProbability(int N, int K, int r, int c) {
        int steps = 0;
        int inRes = 0; //Times that falling inboard
        int row[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int col[] = {1, 2, 2, 1, -1, -2, -2, -1};
        inRes = knightTour(steps, r, c, K, inRes, row, col, N);
        double probability = inRes/(Math.pow(8, K));
        return probability;
    }

    /*
    * r: current row
    * c: current column*/
    public static int knightTour(int steps, int r, int c, int K, int inRes, int[] row, int[] col, int N){
        if (steps == K){
            //backtrack
            inRes++;
            return inRes;
        }

        //check all 8 possible moves for knight and recur for each valid movement
        for(int k=0; k<8; k++){
            int newR = r + row[k];
            int newC = c + col[k];

            //if it's valid and not visited
            if(isValid(newR, newC, N)){
                inRes = knightTour(steps+1, newR, newC, K, inRes, row, col, N);
            }
         }

        //backtrack
        return inRes;
    }

    public static boolean isValid(int x, int y, int N){
        if(x < 0 || y < 0 || x >= N || y >= N){
            return false;
        }else {
            return true;
        }
    }
}
