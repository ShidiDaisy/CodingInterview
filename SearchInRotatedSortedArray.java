/*https://blog.csdn.net/ojshilu/article/details/17485787
 * 循环有序数组：

指的是，将一个有序数组循环左/右移动若干距离之后变成的数组。如，[1,2,3,4,5]循环右移3位，就成为[4,5,1,2,3]。该数组的特点是，其中包含着一个转折点。
转折点左右两侧的子数组都是有序的，并且左侧的子数组整体都比右侧的子数组大。

HINT:
1. 找到转折点在中间的哪一侧
 * */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int search(int A[], int n, int target) {
		int left = 0;
		int right = A.length - 1;
		
		while(left<=right) {
			int mid = left + ((right-left)/2);
			if(A[mid] == target) {
				return mid;
			}
			
			if(A[left] <= A[mid]) {//转折点在右半边，左半边是单调递增的
				if(A[left] <= target && target < A[mid]) {
					//target in left side
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}else {
				//转折点在左半边
				if(A[mid] < target && target <= A[right]) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

}
