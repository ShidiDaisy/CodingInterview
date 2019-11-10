package Recursion;
/*Emma is playing a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2. She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.

For each game, Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided. For example, c = [0, 1, 0, 0, 0, 1, 0] indexed from 0 ... 6. The number on each cloud is its index in the list so she must avoid the clouds at indexes 1 and 5. She could follow the following two paths: 0->2->4->6 or 0->2->3->4->6. The first path takes 3 jumps while the second takes 4.

Function Description

Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.

jumpingOnClouds has the following parameter(s):

c: an array of binary integers
Input Format

The first line contains an integer n, the total number of clouds. The second line contains n space-separated binary integers describing clouds c[i] where 0<=i<n.

Output Format

Print the minimum number of jumps needed to win the game.

Sample Input 0

7
0 0 1 0 0 1 0

Sample Output 0
4*/
import java.util.*;
import java.io.*;
public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c) {
        return recurJump(0, c);
    }

    static int recurJump(int step, int[] c){
        int dist1 = Integer.MAX_VALUE;
        int dist2 = Integer.MAX_VALUE;

        if(step == c.length-1){
            return 0;
        }else {
            if(step+1 < c.length && c[step+1] == 0){
                //save to jump to step+1
                dist1 = recurJump(step+1, c) + 1;
            }

            if(step+2 < c.length && c[step+2] == 0){
                dist2 = recurJump(step+2, c) + 1;
            }
        }
        return Math.min(dist1, dist2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.println(result);

        scanner.close();
    }
}
