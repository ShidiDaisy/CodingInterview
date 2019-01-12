import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LeetCode 
//sum(node) = node value + sum(left value) + sub(right value)
public class findFrequentTreeSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(-5);
		root.left = left;
		root.right = right;
		findFrequentTreeSum(root);
	}
	
	public static int[] findFrequentTreeSum(TreeNode root) {
		//HashMap record: <sum, frequency> 
		Map<Integer, Integer> sumToCount = new HashMap<Integer, Integer>(); 
		int max[] = {0}; //record the number of max frequency
		
		//post traversal
		if(root != null) {
			countSum(root, sumToCount, max);
		}
		
		//put the max frequency into a list
		List<Integer> maxSum = new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> pair:sumToCount.entrySet()) {
			if(pair.getValue() == max[0]) {
				maxSum.add(pair.getKey());
			}
		}
		
		//Transfer list to int[]
		int[] result = new int[maxSum.size()];
		int i=0;
		for(int sum:maxSum) {
			result[i] = sum;
			i++;
		}
		
		System.out.println(result);
		return result;
        
    }
	
	public static int countSum(TreeNode root, Map<Integer, Integer> sumToCount, int[] max) {
		int sum = root.val;
		if(root.left != null) {
			//sum = countSum(child) + root.val
			sum += countSum(root.left, sumToCount, max);
		}
		
		if(root.right != null) {
			sum += countSum(root.right, sumToCount, max);
		}
		
		//Calculate the frequency for current sum
		int count = sumToCount.containsKey(sum) ? sumToCount.get(sum)+1 : 1;
		
		//Put into hashmap
		sumToCount.put(sum, count);
		max[0] = Math.max(max[0], count);
		
		return sum;
	}

}
