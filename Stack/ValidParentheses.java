package Stack;
/*https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 */

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stackChar = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            Character curChar = s.charAt(i);
            if (curChar == '(' || curChar == '{' || curChar == '['){
                stackChar.push(curChar);
            }else {
                if (stackChar.isEmpty()){
                    return false;
                }else {
                    Character popChar = stackChar.pop();
                    if ((curChar == ')' && popChar != '(')
                    || (curChar == ']' && popChar != '[')
                    || (curChar == '}' && popChar != '{')){
                        return false;
                    }
                }
            }
        }

        if(stackChar.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
