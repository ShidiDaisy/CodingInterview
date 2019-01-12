package DP;

import java.util.Scanner;
/*Edit Distance*/
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		String y = sc.nextLine();

		System.out.println(LCS(x, y));
	}
	
	public static int LCS(String x, String y){
		int countMatrix[][] = new int[x.length()+1][y.length()+1];
		for(int i=1; i<=x.length(); i++){
			for(int j=1; j<=y.length(); j++){
				countMatrix[i][j] = Math.max(countMatrix[i-1][j], countMatrix[i][j-1]);
				if(x.charAt(i-1) == y.charAt(j-1)){
					countMatrix[i][j] = countMatrix[i-1][j-1] + 1;
				}
			}
		}
		
		return countMatrix[x.length()][y.length()];
	}

}
