import java.util.Scanner;


public class chaoYouAi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		chaoYouAi sol = new chaoYouAi();
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
