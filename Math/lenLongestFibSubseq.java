package Math;

import java.util.HashMap;
import java.util.Map;

//Leetcode 873
//Dynamic Programming
/*A sequence X_1, X_2, ..., X_n is fibonacci-like if:

n >= 3
X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.

(Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
Example 1:
Input: [1,2,3,4,5,6,7,8]
Output: 5
Explanation:
The longest subsequence that is fibonacci-like: [1,2,3,5,8].
https://mp.weixin.qq.com/s?__biz=MzU5NDIxNjIxMg==&mid=2247484233&idx=1&sn=c0da5cca5fbe9393c606c341b35cb146&scene=19#wechat_redirect
 * */
public class lenLongestFibSubseq {

	public static void main(String[] args) {
		int[] A = new int[]{1,3,7,11,12,14,18};
		System.out.println(lenLongestFibSubseq(A));

	}

	public static int lenLongestFibSubseq(int[] A) {
    
		if(A == null || A.length == 0) {
			return 0;
		}
		
		Map<Integer, Integer> numToIndex = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			numToIndex.put(A[i], i);
		}
		
		int[][] lengths = new int[A.length][A.length];
		
		int length2 = 2;
		for(int i=1; i<A.length; i++) {
			int length1 = 2;
			for(int j=i-1; j>=0; --j) {
				//There exist j, where A[k] + A[j] = A[i], k<j
				int A_k = A[i] - A[j];
				int len = 2; //initial length
				if(A_k<A[j] && numToIndex.containsKey(A_k)) {
					//lengths[i][j] = lengths[j][k] + 1
					len = lengths[j][numToIndex.get(A_k)] + 1;
				}
				
				lengths[i][j] = len;
				//record the max length
				length1 = Math.max(length1, len);
			}
			length2 = Math.max(length1, length2);
		}
		
		return length2 > 2 ? length2 : 0;
    }
}
