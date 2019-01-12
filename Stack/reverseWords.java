package Stack;

import java.util.Scanner;
import java.util.Stack;

public class reverseWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputWords = input.split(" ");
		
		System.out.print(reverseWord(inputWords));
	}

	public static String reverseWord(String[] inputWords){
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<inputWords.length; i++){
			String inputWord = inputWords[i];
			Stack<String> wordsStack = new Stack<String>();
			
			for(int j=0; j<inputWord.length(); j++){
				String c = inputWord.substring(j, j+1);
				wordsStack.push(c);
			}
			
			while(!wordsStack.isEmpty()){
				String elem = wordsStack.pop();
				sb.append(elem);
			}
			sb.append(" ");
		}
		
		return sb.toString().trim();
	} 
}
