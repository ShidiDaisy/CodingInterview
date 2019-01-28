package Sort;

import java.util.Arrays;

/*Divide and Conquer
 * 1. Pivot Selection: Pick an element from array, called a pivot (usually the leftmost or rightmost one)
 * 2. Partitioning: Reorder the array so that all the elements that are less than the pivot come before pivot, 
 * while all elements with values greater than the pivot after it.
 * 3. Recurse: Recursively step 1, 2 to the sub-arrays 
 * */
public class QuickSort {

	public static void main(String[] args) {
		int a[] = {8, 7, 7, 6, 5, 7, 3, 1};
		quickSort(a, 0, a.length-1);
		System.out.print(Arrays.toString(a));
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		//base case
		if(start >= end) {
			return;
		}
		
		//recursively sort less value part and larger value part
		int pivot = partition(start, end, arr);
		quickSort(arr, start, pivot-1);
		quickSort(arr, pivot+1, end);
	}
	
	public static int partition(int start, int end, int[] arr) {
		int pivotVal = arr[end];
		int boundary = start; //The boundary of the values less than pivot and the values great than pivot 
		//0 to arr.len - 1 
		for(int i=start; i<end; i++) {
			if(arr[i] <= pivotVal) {
				swap(arr, i, boundary);
				boundary++;
			}
		}
		swap(arr, boundary, end);
		return boundary;
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
