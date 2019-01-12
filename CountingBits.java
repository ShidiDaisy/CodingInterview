/*Leetcode: 338.Counting Bits
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 
 * 1's in their binary representation and return them as an array.

Example 1:
Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]

Hints: 1. 若只有个位发生变化 100->101, 在f[i] = f［i-1］ + 1 (f[i-1] = f[i&i-1])
2. 若需要进位 101 -> 110, 
 * 
 * */
public class CountingBits {

	public static void main(String[] args) {
		int[] res = countBits(5);
		System.out.println(res);
	}
	
	public static int[] countBits(int nums){
		int[] res = new int[nums+1];
		res[0] = 0;
		for(int i=1; i<=nums; i++){
			res[i] = res[i&i-1] + 1;
		}
		return res;
	}

}
