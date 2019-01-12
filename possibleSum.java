import java.util.Arrays;
import java.util.Scanner;

/*ACTest: 62.5%*/
public class possibleSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfInput = sc.nextInt();
		
		int[] arrayA = new int[numOfInput];
		for(int i=0; i<numOfInput; i++){
			arrayA[i] = sc.nextInt();
		}
		
		int target = sc.nextInt();
		possibleSum sol = new possibleSum();
		System.out.println(sol.findPossibleSum(arrayA, target));
		
	}
	
	public boolean findPossibleSum(int[] arrayA, int target){
		//Sort the array
				Arrays.sort(arrayA);
				
				int sum = 0;
				for(int i=arrayA.length-1; i>=0; i--){
					if(target < arrayA[i]){
						continue;
					}else{
						for(int j=i; j>=0; j--){
							sum += arrayA[j];
							if(sum == target){
								return true;
							}else if(sum > target){
								//test negative number
								for(int k=0; k<j; k++){
									if(arrayA[k] < 0){
										sum += arrayA[k];
										if(sum == target){
											return true;
										}
									}else{
										break;
									}
								}
								
								return false;
							}else{
								continue;
							}
						}
					}
				}
				return false;
	}

}
