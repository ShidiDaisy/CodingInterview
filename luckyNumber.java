import java.math.BigInteger;
import java.util.Scanner;

public class luckyNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		try {
			int L = in.nextInt();
			int H = in.nextInt();
			System.out.println(luckyNumber(L, H));
		}catch(Exception e){
			//Not sure for BigInteger part
			int L = in.nextInt();
			int H = in.nextInt();
			System.out.println(luckyNumber(L, H));
		}
		

	}
	
	public static int luckyNumber(int L, int H) {
		int ans = 0;
		for(int i=L; i<=H; i++) {
			boolean eightNums = false;
			boolean sixNums = false;
			int x = i;
			while(x != 0) {
				if(x % 10 == 8) {
					if(eightNums == false && sixNums == false) {
						ans++;
						eightNums = true;
					}else if(sixNums == true) {
						ans--;
						break;
					}
				}
				
				if(x % 10 == 6) {
					if(eightNums == false && sixNums == false) {
						ans++;
						sixNums = true;
					}else if(eightNums == true) {
						ans --;
						break;
					}
				}
				x /= 10;
			}
		}
		return ans; 
	}
	
	public static int luckyNumber(BigInteger L, BigInteger H) {
		int ans = 0;
		for(BigInteger i=L; i.compareTo(H)<=0; i=i.add(BigInteger.ONE)) {
			boolean eightNums = false;
			boolean sixNums = false;
			BigInteger x = i;
			while(x.compareTo(BigInteger.ZERO) != 0) {
				if(x.mod(BigInteger.TEN)  == BigInteger.valueOf(8)) {
					if(eightNums == false && sixNums == false) {
						ans++;
						eightNums = true;
					}else if(sixNums == true) {
						ans--;
						break;
					}
				}
				
				if(x.mod(BigInteger.TEN) == BigInteger.valueOf(6)) {
					if(eightNums == false && sixNums == false) {
						ans++;
						sixNums = true;
					}else if(eightNums == true) {
						ans --;
						break;
					}
				}
				x.divide(BigInteger.TEN);
			}
		}
		return ans; 
	}
}
