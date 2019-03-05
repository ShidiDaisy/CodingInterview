public class kthLargestElem {

    /**
     * Find K-th largest element in an array.
     *
     * Example
     * Example 1:
     *
     * Input:
     * n = 1, nums = [1,3,4,2]
     * Output:
     * 4
     * Example 2:
     *
     * Input:
     * n = 3, nums = [9,3,2,4,8]
     * Output:
     * 4
     * Challenge
     * O(n) time, O(1) extra memory.
     *
     * Notice
     * You can swap elements in the array
     * Quick Sort -> return the kth largest element
     *
     * @param n : An integer
     * @param nums : An array
     * @return : the Kth largest element
     * */
    public static int kthLargestElement(int n, int[] nums){
        if(n < 1 || n > nums.length || nums == null || nums.length == 0){
            return -1;
        }else{
            return partition(0, nums.length-1, nums, nums.length-n);
        }
    }

    /**
     * Recursively sort in ascending order (Quick sort)
     * @return the kth last element in sorted array*/
    public static int partition(int startInd, int endInd, int[] nums, int k) {
        //base case:
        if (startInd >= endInd) {
            return nums[k];
        }

        //partition into two half
        int pivot = nums[(startInd + endInd) / 2];
        int leftInd = startInd;
        int rightInd = endInd;

        while(leftInd <= rightInd){
            //find the element in left side which is larger than pivot
            while(leftInd <= rightInd && nums[leftInd] < pivot){
                leftInd++;
            }

            //find the element in right side which is smaller than pivot
            while(leftInd <= rightInd && nums[rightInd] > pivot){
                rightInd--;
            }

            //rightInd could < leftInd
            if (leftInd <= rightInd){
                swap(nums, leftInd, rightInd);
                leftInd++;
                rightInd--;
            }
        }

        //recursively sort the part that k is in
        //if kth is at left part
        if(k<=rightInd){
            return partition(startInd, rightInd, nums, k);
        }

        //if kth is at right part
        if(k>=leftInd){
            return partition(leftInd, endInd, nums, k);
        }

        return nums[k];
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int n = 1;
        int[] nums = {1,3,4,2};
        System.out.println(kthLargestElement(n, nums));
    }

}
