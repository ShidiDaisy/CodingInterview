package Stack;

import java.util.Stack;

/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

HINT:
Keep the min in a minStack
https://www.jiuzhang.com/solution/min-stack/
https://leetcode.com/problems/min-stack/

 * */
public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int number) {
		stack.push(number);
		
		if(minStack.isEmpty()) {
			minStack.push(number);
		}else {
			minStack.push(Math.min(number, minStack.peek())); //peek: keep the minStack.size = stack.size
			//stack: [2,3,1,4,0]
			//minStack: [2,2,1,1,0]
		}
	}
	
	public int pop() {
		minStack.pop();
		return stack.pop();
	}
	
	public int min() {
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		MinStack minstack = new MinStack();
		minstack.push(1);
		System.out.println(minstack.pop());  // return 1
		minstack.push(2);
		minstack.push(3);
		System.out.println(minstack.min());   // return 2
		minstack.push(1);
		System.out.println(minstack.min());   // return 1
	}
}
