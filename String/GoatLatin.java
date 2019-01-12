package String;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class GoatLatin {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String S = scan.nextLine();
		toGoatLatin(S);
	}
	
	public static String toGoatLatin(String S) {
		Set<Character> vowel = new HashSet<Character>();
		StringBuilder ans = new StringBuilder();
		String endWord = "a";
		
		for(char c:new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'I', 'E', 'O', 'U'}) {
			vowel.add(c);
		}
		//Split the sentence into word
		for(String word:S.split(" ")) {
			if(vowel.contains(word.charAt(0))) {
				word = word + "ma";
			}else {
				//remove the first letter
				String firstLetter = word.substring(0, 1);
				word = word.substring(1, word.length());
				
				//append to the end and add "ma"
				word = word + firstLetter;
				word = word + "ma";
			}
			word = word + endWord;
			ans.append(word);
			ans.append(" ");
			
			endWord += "a";
		}
		
		ans.deleteCharAt(ans.length() - 1);
		System.out.println(ans);
		return ans.toString();
	}

}
