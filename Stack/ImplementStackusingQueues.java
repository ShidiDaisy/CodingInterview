package Stack;
import java.util.LinkedList;
import java.util.Queue;

/*Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only 
1. push to back - offer()
2. peek/pop from front: poll() - retrieve and remove from front
3. size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

HINT:
利用两个Queue, 每次插入的时候把元素插入到Queue头部
1. StackQueue: [3,2,1], Temp=[]
2. StackQueue: [], Temp = [3,2,1]
3. StackQueue: [4] Temp = [3,2,1]
4. StackQueue: [4,3,2,1]

*/
public class ImplementStackusingQueues {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		stack.pop();
		stack.top();
		stack.empty();
		stack.pop();
		stack.pop();
		stack.empty();
		System.out.println();

	}

}

class MyStack{
	private Queue<Integer> q = new LinkedList<Integer>();
	public MyStack() {}
	
	public void push(int x) {
		Queue<Integer> tempQ = new LinkedList<Integer>();
		while(!q.isEmpty()) {
			tempQ.offer(q.poll());
		}
		
		q.offer(x);
		
		while(!tempQ.isEmpty()) {
			q.offer(tempQ.poll());
		}
	}
	
	//Removes the element on top of the stack and return this element.
	public int pop() {
		return q.poll();
	}
	
	//Get the top element
	public int top() {
		return q.peek();
	}
	
	//Return whether the stack is empty
	public boolean empty() {
		return q.isEmpty();
	}
}
