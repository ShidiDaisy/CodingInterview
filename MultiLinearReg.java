import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MultiLinearReg {
	private static Scanner scan;
	public static void main(String[] args) {
		//X = A^-1 * B
		//Get input A
		scan = new Scanner(System.in);
		String line1 = scan.nextLine();
		String[] line1Arr = line1.split("],");
		List<String[]> A = new ArrayList<String[]>();
		
		for (String item:line1Arr) {
			String temp = item.replace("[","").replace("]", "");
			String[] nums = temp.split(",");
			A.add(nums);
		}
		
		//Get input B
		String line2 = scan.nextLine();
		String temp = line2.replace("[", "").replace("]", "");
		String[] B = temp.split(","); 
		System.out.println();
		
		
	}

}
