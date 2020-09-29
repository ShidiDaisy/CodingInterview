package DP;

/*Find a subsequence of a given sequence in which the subsequence's elements are in sorted order,
 * lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily
 * contiguous, or unique
 * 
 * For example, consider subsequence {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}
 * The longest increasing subsequence is {0, 2, 6, 9, 11, 15}
 * 
 * Main Idea: Dynamic Programming
 * Recursively solve the problem, for each of the element in input array
 * to see, is including current number will have larger result or excluding this number will have larger result*/
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println(findLIS(A, 0, Integer.MIN_VALUE));
	}
	/**
	 * i: current index
	 * prev: prev num
	 * */
	public static int findLIS(int arr[], int i, int prev) {
		//base case
		if(i == arr.length) {
			return 0;
		}

		//case1: if current item in LIS is greater than the previous element in LIS then recurse for remaining items
		int incl = 0;
		if(arr[i] >= prev) {
			incl = 1 + findLIS(arr, i+1, arr[i]);
		}
		
		//case 2: exclude current item and continue
		int excl = findLIS(arr, i+1, prev);
		
		return Integer.max(incl, excl);
		
	}

}
