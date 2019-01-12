/*326. Power of Three
 * Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false

Input: 1
Output: true
*/
public class PowerofThree {

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(2147483647));
	}
	
	public static boolean isPowerOfThree(int n) {
		long powOfThree = 1; 
		while(n>0){
			if(n == powOfThree){
				return true;
			}else if(n < powOfThree){
				return false;
			}else{
				powOfThree *= 3;
			}
		}
		return false;
        
    }

}
