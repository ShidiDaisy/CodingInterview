package Array;
//https://leetcode.com/problems/two-sum/
//1. Two Sum
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]

//[-1,-2,-3,-4,-5]
//        -8

//[3,2,4]
//        6

import java.util.Arrays;

//如果数组是sort过的：放两个指针在两头，如果sum大于target，右边指针往左移。如果sum小于target，左边指针往右移
//没有sort的，两层嵌套forloop
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(twoSum(nums, target));
    }

    public static int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        for(int i=0; i < nums.length-1; i++){
            for(int j=i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if (sum == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
    public static int[] twoSumForSorted(int[] nums, int target) {
        int leftInd = 0;
        int rightInd = nums.length - 1;

        int sum = nums[leftInd] + nums[rightInd];
        int[] res = new int[2];
        while (sum != target){ //assume that each input would have exactly one solution
            if (sum < target){
                leftInd++;
            }else if(sum > target){
                rightInd--;
            }
            sum = nums[leftInd] + nums[rightInd];
        }

        res[0] = leftInd;
        res[1] = rightInd;

        return res;
    }
}
