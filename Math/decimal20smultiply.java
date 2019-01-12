package Math;

import java.math.BigInteger;
import java.util.Scanner;

/*10进制20位数乘法
 * 
 * input:200000000000000000000
 * 300000000000000000000
 * 
 * output：60000000000000000000000000000000000000000*/
public class decimal20smultiply {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger bi1 = sc.nextBigInteger();
		BigInteger bi2 = sc.nextBigInteger();
		
		BigInteger res = bi1.multiply(bi2);
		System.out.println(res);
	}

}
