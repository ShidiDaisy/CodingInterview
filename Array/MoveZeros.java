package Array;
/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.*/

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int j = 0; //Non-zero elements will go to this index

        // 1. Iterate every element in the array
        for (int i = 0; i < nums.length; i++){
            // if nums[i] == 0 -> j track this location -> j keep the same
            // if nums[i] != 0 -> move the element at i to j index, j move to next index
            if (nums[i] != 0){
                nums[j] = nums[i];

                if(i!= j){
                    // the original element in this index has been moved, replace this index with 0
                    nums[i] = 0;
                }

                j++;
            }
        }

        for (int n:nums) {
            System.out.print(n);
        }
    }

    public void moveZeros2(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }

        int cur = 0;

        //swap the zero with non-zeros element
        for(int i=0; i<nums.length; i++){
            if (nums[i] != 0){
                //swap with 0
                int temp = nums[i];
                nums[cur++] = nums[i];
                nums[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int[] nums = {0,1,0,3,12};
        mz.moveZeroes(nums);
    }
}
