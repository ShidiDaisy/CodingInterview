package Math;
/*Question: Reverse integer
 * Input: 100
 * Output: 1
 * 
 * Input: -100
 * Output -1
 * 
 * Input 123
 * Output 321
 * 
 * ACTest: 93.5%*/
import java.util.Scanner;

public class reverseInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		int inNum = input;
		
		StringBuilder sb = new StringBuilder();
		input = Math.abs(input);
		while(input > 0.1){
			int digit = input%10;
			input = input/10;
			sb.append(digit);
		}
		
		int result;
		if(inNum > 0){
			result = Integer.parseInt(sb.toString());
		}else{
			result = Integer.parseInt(sb.toString()) * -1;
		}
		System.out.println(result);
	}

}
