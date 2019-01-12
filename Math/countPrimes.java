package Math;
//LeetCode 204
/*Count the number of prime numbers less than a non-negative number, n.

Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Sol: ������˹����ɸ�� 
https://www.wikiwand.com/zh-sg/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95
 * */
public class countPrimes {

	public static void main(String[] args) {
		int count = countPrimes(10);
		System.out.println(count);
	}
	
	public static int countPrimes(int n) {
		if(n <= 2) {
			return 0;
		}
		
		boolean[] primes = new boolean[n];
		for(int i=2; i<n; i++) {
			primes[i] = true;
		}
		
		//loop until sqrt(n), cause: a*a = n; the number behind a already visited
		for(int i=2; i<Math.sqrt(n); i++) {
			if(primes[i]) {
				for(int j=i*i; j<n; j=j+i) {
					primes[j] = false;
				}
			}
		}
		
		//Output the number of true;
		int count = 0;
		for(int i=2; i<n; i++) {
			if(primes[i]) {
				count++;
			}
		}
		return count;
    }

}
