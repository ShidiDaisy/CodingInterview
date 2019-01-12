package Math;
/*Input: 0xA
 *Output: 10
 *
 *Input: 0x76E
Output: 1902*/
import java.util.Scanner;

public class HexToDec {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HexToDec hd = new HexToDec();
		while(sc.hasNext()){
			String hex = sc.nextLine();
			System.out.println(hd.convertToDec(hex));
		}

	}

	public int convertToDec(String hex){
		String digits = "0123456789ABCDEF";
		hex = hex.substring(2).toUpperCase();
		int res = 0;
		int mul = 1;
		
		for(int i=hex.length()-1; i>=0; i--){
			char c = hex.charAt(i);
			int val = digits.indexOf(c);
			
			res += val*mul;
			mul *= 16;
		}
		
		return res;
		
	}
}
