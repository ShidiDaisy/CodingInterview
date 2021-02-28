import java.util.Scanner;


public class debugTool {

	public static void main(String[] args){
		try{
			Float f1 = new Float("3.0");
			int x = f1.intValue();
			byte b = f1.byteValue();
			double d = f1.doubleValue();
			System.out.println(x + b + d);
		}catch (NumberFormatException e)
		{
			System.out.println("bad number");
		}

		/* Here is a comment **** */
//		int i = 010;
//		int j = 07;
//		System.out.println(i);
//		System.out.println(j);

//		try{
//			System.out.println("A");
//			badMethod();
//			System.out.println("B");
//		}catch(Exception ex){
//			System.out.println("C");
//		}finally{
//			System.out.println("D");
//		}
	}
	public static void badMethod(){
		throw new Error();
	}
}
