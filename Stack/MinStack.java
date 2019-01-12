package Stack;

import java.util.Stack;

/*实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。

HINT:
Keep the min in a minStack
https://www.jiuzhang.com/solution/min-stack/
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
