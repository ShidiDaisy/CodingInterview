package QueueEx;
/*Implement queue by circulant array. You need to support the following methods:

CircularQueue(n): initialize a circular array with size n to store elements
boolean isFull(): return true if the array is full
boolean isEmpty(): return true if there is no element in the array
void enqueue(element): add an element to the queue
int dequeue(): pop an element from the queue*/
public class CircularQueue {

	private int[] circular;
	private int front;
	private int rear;
	private int size;
	
	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(5);
		System.out.println(cq.isFull());
		System.out.println(cq.isEmpty());
		cq.enqueue(1);
		System.out.println(cq.dequeue());

	}
	
	public CircularQueue(int n) {
		circular = new int[n];
		front = 0;
		rear = 0;
		size = 0;
	}
	
	public boolean isFull() {
		return size == circular.length;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(int element) {
		circular[rear++] = element;
		size++;
		
		if(rear == circular.length) {
			rear = 0;
		}
	}
	
	public int dequeue() {
		//dequeue from front
		int element = circular[front++];
		size--;
		
		if(front == circular.length) {
			front = 0;
		}
		return element;
	}
}
