package Queue;

import java.util.Stack;

/*����Ҫʹ������ջ��ʵ�ֶ��е�һЩ������
����Ӧ֧��push(element)��pop() �� top()������pop�ǵ��������еĵ�һ��(��ǰ���)Ԫ�ء�
pop��top������Ӧ�÷��ص�һ��Ԫ�ص�ֵ��

HINT
2 stacks
stack2 keep the reverse version of first part
stack1 keep next part, reverse to stack when stack2 is empty
*/
public class QueuebyStacks {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	public static void main(String[] args) {
		QueuebyStacks qs = new QueuebyStacks();
		qs.push(1);
		System.out.println(qs.pop());
		qs.push(2);
		qs.push(3);
		System.out.println(qs.top());
		System.out.println(qs.pop());

	}
	
	//Constructor
	public QueuebyStacks() {
		stack1 = new Stack<Integer>(); //����
		stack2 = new Stack<Integer>(); //����
	}

	public void push(int element) {
		stack1.push(element); //[1,2,3]
	}
	
	public int pop() {
		if(stack2.empty()) {
			this.reverseStack();
		}
		return stack2.pop();
	}
	
	public void reverseStack() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}
	
	public int top() {
		if(stack2.empty()) {
			this.reverseStack();
		}
		return stack2.peek();
	}
}
