import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*input: BACCAAHEFGHFF*/
public class hwawei1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(findLastOnlyChar(input));
	}

	public static String findLastOnlyChar(String input){
		Map<String, Integer> char2Count = new HashMap<String, Integer>();
		Stack<String> charStack = new Stack<String>();
		
		for(int i=0; i<input.length(); i++){
			String c = String.valueOf(input.charAt(i));
			charStack.push(c);
			if(!char2Count.containsKey(c)){
				char2Count.put(c, 1);
			}else{
				char2Count.put(c, char2Count.get(c)+1);
			}
		}
		
		while(!charStack.isEmpty()){
			String elem = charStack.pop();
			if(char2Count.get(elem) == 1){
				return elem;
			}
		}
		return "NULL";
	}
}
