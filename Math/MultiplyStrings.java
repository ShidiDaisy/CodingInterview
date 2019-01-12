package Math;
/*43. Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * */
public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));

	}
	
	public static String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int product = 0;
		int len3 = len1 + len2;
		int[] num3 = new int[len3];
		int i;
		
		for(int j=len2-1; j>=0; j--){
			int carry = 0;
			for(i=len1-1; i>=0; i--){
				product = carry + num3[i+j+1] + 
						Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
				num3[i+j+1] = product%10;
				carry = product/10;
			}
			num3[i+j+1] = carry;
		}
		
		StringBuilder sb = new StringBuilder();
		//Find the first non-zero digit
		int j=0;
		while(j<len3-1 && num3[j]==0){
			j++;
		}
		
		while(j<len3){
			sb.append(num3[j]);
			j++;
		}
			
		
        return sb.toString();
    }

}
