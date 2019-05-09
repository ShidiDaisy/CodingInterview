package Graph;
/*Perform search in ascending sequence
 *  Example:
 * Input:
 * arr[] = [2, 3, 5, 7, 9]
 * target = 7
 * 
 * Output: Element found at index 3
 * 
 * Input:
 * arr[] = [1, 4, 5, 8, 9]
 * target = 2
 * 
 * Output: Element not found
 * 
 * 1. If target = A[mid], return mid.
 * 2. If target < A[mid], discard right subnet including mid element
 * 3. If target > A[mid], discard all elements in the left subnet including the mid element
 * 4. Repeat the process 1, 2, 3 until the target = A[mid] or arr.length == 0;
 * */
public class BinarySearch {

	public static void main(String[] args) {
		int[] A = {2, 5, 6, 8, 9, 10};
		int target = 5;
		int index = binarySearch(A, target);
		
		if(index != -1) {
			System.out.println("Element found at index: " + index);
		}else {
			System.out.println("Element is not found");
		}

	}
	
	public static int binarySearch(int[] A, int x) {
		int leftBound = 0;
		int rightBound = A.length - 1; 
		
		while(leftBound <= rightBound) {
			int mid = (leftBound + rightBound)/2;
			if(x == A[mid]) {
				return mid;
			}else if(x < A[mid]){
				//discard right side
				rightBound = mid - 1;
			}else {
				leftBound = mid + 1;
			}
		}
		return  -1;
	}
}
