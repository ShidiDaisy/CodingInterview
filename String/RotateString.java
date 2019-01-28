package String;

import java.util.ArrayList;

/*Given a string and an offset, rotate string by offset. (rotate from left to right)

*Given "abcdefg".

offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"

Sol: 涓夋鍙嶈浆娉�
offset=2 
1. Split the string into two parts by offset: abcde, fg
2. Reverse the first part: edcba,
3. Reverse the second part: gf
4. Combine two part and reverse the entire string锛� edcbagf -> fgabcde
*/
public class RotateString {

	public static void main(String[] args) {
		String input = "";
		char[] str = input.toCharArray();
		rotateString(str, 10);
		System.out.println(str);

	}
	
	/**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
        if(str.length == 0){
        	return; //exist the method
        }else{
            offset %= str.length; //if offset>n, then is equal to offset%str,length 
        	reverse(str, 0, str.length-offset-1);
            reverse(str, str.length-offset, str.length-1);
            reverse(str, 0, str.length-1);
        }
    }
    
    public static void reverse(char[] str, int start, int end){
    	for(int i=start, j=end; i<j; i++, j--){
    		char temp = str[i];
    		str[i] = str[j];
    		str[j] = temp;
    	}
    }

}
