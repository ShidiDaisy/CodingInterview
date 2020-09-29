package Array;
//https://leetcode.com/problems/container-with-most-water/
//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
// are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
// forms a container, such that the container contains the most water.
//
// Note: You may not slant the container and n is at least 2.
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue
// section) the container can contain is 49.
//
//Example:
//
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49

public class ContainerWithMostWater {
    // 1. 枚举, left bar x, right bar y, area = (y-x) * height_diff
//    O(n^2)
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = i + 1; j < height.length; j++){
                // j starts from the next number after i
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Integer.max(area, max);
            }
        }
        return max;
    }

    // 2. 左右边界向中间收敛
    // Two pointer point to two ends
    // each time, move the shorter bar towards center
    // until two pointers meet each other.
    // O(n)
    public int maxArea2(int[] height){
        int max = 0;
//        initial i, j point to two ends
        for(int i = 0, j = height.length - 1; i < j;){

            // move the shorter bar
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight; //i and j has already been moved to the next index, +1 to go back
            max = Math.max(max, area);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater sol = new ContainerWithMostWater();
        System.out.print(sol.maxArea2(height));
    }
}
