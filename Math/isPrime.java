package Math;
import java.util.Scanner;

/* Check whether the number n can be divided by any number between 2 to n/2*/
public class isPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		isPrime sol = new isPrime();
		System.out.println(sol.isPrime(num));
		System.out.println(sol.isPrime2(num));
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

	public boolean isPrime2(int num){
		if(num < 2){
			return false;
		}else{
			for(int i=2; i < num/2; i++){
				if(num%i == 0){
					return false;
				}
			}
		}
		return true;
	}
}
