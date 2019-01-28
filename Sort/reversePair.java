package Sort;
import java.util.Arrays;

/*在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。给你一个数组，求出这个数组中逆序
 * 对的总数。
概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对。

Hint: Merge Sort
 * */
public class reversePair {

	public static void main(String[] args) {
		int[] A = new int[] {4,3,2,1};
		System.out.println(reversePairs(A));
	}
	
	/**
     * @param A: an array
     * @return: total of reverse pairs
     */
    public static long reversePairs(int[] A) {
    	return mergeSort(A, 0, A.length-1);
    }
    
    public static int mergeSort(int[] A, int start, int end) {
    	if(start < end){
    		int mid = (start + end)/2; //end of left part
    		int sum = 0;
    		//Find the reverse pairs at each part
    		sum += mergeSort(A, start, mid);
    		sum += mergeSort(A, mid+1, end);
    		//Merge two parts
    		sum += merge(A, start, mid, end);
    		
    		return sum;
    	}else{
    		return 0;
    	}
    }
    
    public static long merge(int A[], int start, int mid, int end){
    	int i = start;
    	int j = mid+1;
    	int ind = start;
    	int sum = 0;
    	int temp[] = new int[A.length];
    	
    	while(i<=mid && j<=end) {
    		if(A[i] > A[j]){
        		temp[ind++] = A[j++];
        		sum += mid - i + 1; //3,6 + 2,7 - 如果左边的数大于右边的数了，那l[i] to l[end] 一定都> r[j], 因为 l sorted.
        	}else {
        		temp[ind++] = A[i++];
        	}
    	}
    	
    	//copy reset to the temp[]
    	while(i<=mid) {
    		temp[ind++] = A[i++];
    	}
    	while(j<=end) {
    		temp[ind++] = A[j++];
    	}
    	
    	for(int k=start; k<=end; k++) {
    		A[k] = temp[k];
    	}
    	
		return sum;
    }

}
