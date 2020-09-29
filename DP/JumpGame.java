package DP;
/**Leetcode 55 Jump Game
 * https://leetcode.com/problems/jump-game/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it
 * impossible to reach the last index.*/

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n];
        f[0] = true; //initial state

        //start from the second num
        for(int j=1; j < n; j++){
            //回头枚举跳过来的石头
            f[j] = false;
            for(int i = 0; i < j; i++){
                if(f[i] && i + nums[i] >= j){
                    f[j] = true;
                    break;
                }
            }
        }

        return f[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
