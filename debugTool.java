import java.util.Scanner;


public class debugTool {

	public static void main(String[] args) {
		System.out.print(countNum());

	}

	public static int countNum(){
		Scanner in = new Scanner(System.in);
		
		int a=0;
		while(in.hasNext()){
			a++;
		}
		
		return a;
		
	}
}
