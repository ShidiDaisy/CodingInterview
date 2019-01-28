package Sort;

import java.util.Arrays;

/*Divide the array into two subnets: sorted and unsorted 
 * 1. Initially: sorted subnet consist of only one first element at index 0
 * 2. Each iteration. remove the next element from unsorted subnet, and insert into the right place in sorted subnet
 * 3. Repeat until no input element remain*/
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {8, 7, 7, 6, 5, 7, 3, 1};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void insertionSort(int[] arr) {
		//Start from the second element
		for(int i=1; i<arr.length; i++) {
			int j = i;
			int val = arr[j]; //insert this element to sorted subnet
			
			//check j>0 first to avoid ArrayIndexOutOfBoundsException
			while(j > 0 && val < arr[j-1]) {
				//Shift val to one right place
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = val;
		}
	}

}
