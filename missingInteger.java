import java.util.HashSet;
import java.util.Set;

/*that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 * */
public class missingInteger {

	public static void main(String[] args) {
		int[] A = new int[] {-1, -3};
		System.out.println(solution(A));

	}
	
	public static int solution(int[] A) {
		Set<Integer> hSet = new HashSet<Integer>();
		for(int i=0; i<A.length; i++) {
			hSet.add(A[i]);
		}
		
		int result = 1;
		while(hSet.contains(result)) {
			result++;
		}
		
		return result;
    }

}
