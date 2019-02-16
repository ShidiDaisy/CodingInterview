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
		System.out.println(kadane(A));
	}
	
	public static int kadane(int[] A) {
		//stores maximum sum sub-array found so far
		int maxEndingHere = 0;
		int max = 0;
		
		for(int a:A) {
			maxEndingHere = maxEndingHere + a;
			
			//Not counted if the number is less than 0
			maxEndingHere = Integer.max(maxEndingHere, 0);
			
			max = Integer.max(max, maxEndingHere);
		}
		
		return max;
	}
}
