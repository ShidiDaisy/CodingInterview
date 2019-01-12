package String;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
/*Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some 
 * characters of the given string. 
 * If there are more than one possible results, return the longest word with the smallest lexicographical order. 
 * If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
 * */
public class findLongestWord {

	public static void main(String[] args) {
		String s = args[0];
		List<String> d = new ArrayList<String>();
		for(int i=1; i<args.length; i++) {
			d.add(args[i]);
		}
		findLongestWord(s, d);
	}
	
	public static String findLongestWord(String s, List<String> d) {
		List<String> ansList = new ArrayList<String>();
		String ans = "";
		
		for(String word:d) {
			int j = 0;
			int i = 0; 
			for(i=0; i<s.length() && j<word.length(); i++) {
				if(word.charAt(j) == s.charAt(i)) {
					j++;
				}
			}
			
			//if i reach the end -> no match
			if(j == word.length()) {
				ansList.add(word);
			}
		}
		
		/*If there are more than one possible results*/
		List<String> sameLenAns = new ArrayList<String>();
		if(ansList.size() > 1) {
			Collections.sort(ansList, new Comparator<String>() {

				//Compare length, than lexicographically
				@Override
				public int compare(String o1, String o2) {
					return o2.length()!=o1.length() ? o2.length()-o1.length() : o1.compareTo(o2);
				}
				
			});
		}

		if(ansList.isEmpty()) {
			ans = "";
		}else {
			ans = ansList.get(0);
		}
		System.out.println(ans);
		return ans;
        
    }
	

}
