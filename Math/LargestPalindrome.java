package Math;
/*A palindrome is a word or phrase that reads the same backwards. For example these words are palindromes: madam, racecar, redder. Note that there may be an odd or even number of characters.
 
A number can be considered a palindrome in the same way. For example, these numbers are palindromes:  1234321, 404, 99.
 
Write a computer program with a function "part1" to find the largest palindrome number 
that can be generated by multiplying two four digit numbers together. 

Output:  two four digit numbers and the palindrome number obtained by multiplying them
how long the function takes to finish.

Part 2:
For part2, your function needs to find the largest palindrome number that 
a) can be generated by multiplying two four digit numbers together *and* 
b) has digits that sum to 28
 
For example the number 1234567 has digits that sum to 1+2+3+4+5+6+7 = 28, but obviously 1234567 is not a palindrome!
Output: the two four digit numbers and the palindrome number obtained by multiplying them. Also, output how long the function takes to finish.
*/
public class LargestPalindrome {

	public static void main(String[] args) {
		//PART 1
		System.out.println("Part 1:");
		long startTime1 = System.currentTimeMillis();
		
		int digits = 4;
		int upperBound = (int)Math.pow(10, digits) - 1; //9999
		int lowerBound = (int)Math.pow(10, digits - 1); //1000
		int[] part1Res = findLargestPalindrome(upperBound, lowerBound);
		System.out.println(part1Res[0] + " " + part1Res[1]);
		System.out.println(part1Res[2]);
		
		long endTime1 = System.currentTimeMillis();
		long totalTime1 = endTime1 - startTime1;
		System.out.println("Running Time (ms): " + totalTime1);
		
		//PART 2
		System.out.println("\nPart 2:");
		long startTime2 = System.currentTimeMillis();
		int[] part2Res = findLargestPalindrome(upperBound, lowerBound, 28);
		System.out.println(part2Res[0] + " " + part2Res[1]);
		System.out.println(part2Res[2]);
		
		long endTime2 = System.currentTimeMillis();
		long totalTime2 = endTime2 - startTime2;
		System.out.println("Running Time (ms): " + totalTime2);
		
	}
	
	public static int[] findLargestPalindrome(int upperBound, int lowerBound) {
		
		int maxProd = 0;
		int num1 = 0;
		int num2 = 0;
		for(int i = upperBound; i >= lowerBound; i--) {
			for(int j = i; j >= lowerBound; j--) {
				int product = i * j;
				if(product > maxProd) {
					if(isPalindrome(product)) {
						maxProd = product;
						num1 = i;
						num2 = j;
					}
				}else {
					//all the following j will be smaller
					break;
				}
			}
		}
		
		int[] res = new int[] {num1, num2, maxProd};
		return res;
	}

	public static boolean isPalindrome(int num) {
		String prodStr = Integer.toString(num);
		
		int j = prodStr.length() - 1;
		for(int i=0; i<prodStr.length()/2; i++){
			if(prodStr.charAt(i) != prodStr.charAt(j)){
				return false;
			}else{
				j--;
			}
		}
		return true;
	}
	
	public static int[] findLargestPalindrome(int upperBound, int lowerBound, int expectedSum) {
		int maxProd = 0;
		int num1 = 0;
		int num2 = 0;
		for(int i = upperBound; i >= lowerBound; i--) {
			for(int j = i; j >= lowerBound; j--) {
				int product = i * j;
				if(product > maxProd) {
					if(isPalindrome(product) && checkSum(product, 28)) {
						maxProd = product;
						num1 = i;
						num2 = j;
					}
				}else {
					//all the following j will be smaller
					break;
				}
			}
		}
		
		int[] res = new int[] {num1, num2, maxProd};
		return res;
	}
	
	public static boolean checkSum(int palin, int expectedSum) {
		int sum = 0;
		while(palin > 0) {
			int digit = palin%10;
			sum += digit;
			palin /= 10;
		}
		
		if(sum == expectedSum) {
			return true;
		}else {
			return false;
		}
	}

}

