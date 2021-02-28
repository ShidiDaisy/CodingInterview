package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//15. 3Sum: https://leetcode.com/problems/3sum/

//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
// triplets in the array which gives the sum of zero.
//
//        Notice that the solution set must not contain duplicate triplets.
//
//
//
//        Example 1:
//
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]

//        Example 2:
//
//        Input: nums = []
//        Output: []

//        Example 3:
//
//        Input: nums = [0]
//        Output: []

//        Example 4:
//        Input: [-2,0,0,2,2]
//        Output: [[-2,0,2]]


//思路：
//1. Sort array
//2. 衍生2Sum的思路, 3Sum为：a+b = -c, -c is target
// 2.1 第一层for loop 枚举array中的k as target
// 2.2 对于每一个k(target)，在k右边的数组中的两头放两个指针
// 2.3 sum指针所在位置的数
// 2.4 如果sum大于target，右边指针往左移。如果sum小于target，左边指针往右移

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // 留两个位置给 指针
        for(int k=0; k < nums.length - 2; k++){
            if(nums[k] > 0){
                break;
            }

            // k>0: 避免k-1 out of range, nums[k] == nums[k-1]: 不重复判断同样的target.
            if(k > 0 && nums[k] == nums[k-1]){
                continue;
            }

            int i = k + 1, j = nums.length - 1;
            while (i < j){
                int sum = nums[i] + nums[j];
                if(sum < -nums[k]){
                    //left pointer move right
                    while(i < j && nums[i] == nums[++i]); //skip this i if nums[i] is same as previous
                }else if(sum > -nums[k]){
                    while(i < j && nums[j] == nums[--j]);
                }else{
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
