package Math;
/*Given an array of integers, find contiguous subarray within it which has the largest sum
 * For example.
 * Input: {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 * Output: Subarray with the largest sum is {4, -1, 2, 1}
 * 
 * Kadane's algorithm:
 * Maintain maximum positive sum sub-array's ending*/
public class MaxSubarray {

	public static void main(String[] args) {
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int[] B = {-8, -3, -6, -2, -5, -4};
		System.out.println(kadane(B));
	}
	
	public static int kadane(int[] A) {
		//stores maximum sum sub-array found so far
		int curMax = A[0];
		int max = A[0];
		
		for(int i=1; i<A.length; i++) {
			curMax = curMax + A[i];
			
			//if this num is making the sum smaller, then should get rid of this num.
			//If (sum + thisNum) < thisNum -> sum<0 && sum<thisNum -> get rid of this sum, start counting
			//a new sum with thisNum
			curMax = Integer.max(curMax, A[i]);
			
			max = Integer.max(max, curMax);
		}
		
		return max;
	}
}
