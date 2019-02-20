package Math;
import java.util.Scanner;


public class isPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		isPrime sol = new isPrime();
		System.out.println(sol.isPrime(num));
	}
	
	public boolean isPrime(int num){
		if(num < 2){
			return false;
		}else{
			for(int i=2; i < num; i++){
				if(num%i == 0){
					return false;
				}
			}
			return true;
		}
	}
}
