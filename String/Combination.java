package String;
import java.util.ArrayList;
import java.util.List;

public class Combination {

	public static void main(String[] args) {
		solution(1213);

	}

	public static int solution(int N) {
		String N_String = Integer.toString(N);
		String[] digits = new String[N_String.length()];
		for(int i=0; i<digits.length; i++) {
			 digits[i] = N_String.substring(i, i+1);
		}
		
		List<String> result = new ArrayList<String>();
		for(int i=0; i<digits.length; i++) {
			for(int j=i; j<digits.length; j++) {
				String res = "";
				for(int k=i; k<=j; k++) {
					res = res + digits[k];
				}
				
				if(!result.contains(res)) {
					result.add(res);
				}
			}
		}
		
		
		System.out.println(result);
		return N;
    }
}
