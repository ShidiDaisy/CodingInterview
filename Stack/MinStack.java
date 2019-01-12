package Stack;

import java.util.Stack;

/*ʵ��һ������ȡ��Сֵmin������ջ��min���������ص�ǰջ�е���Сֵ��
��ʵ�ֵ�ջ��֧��push��pop �� min ���������в���Ҫ����O(1)ʱ������ɡ�

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
