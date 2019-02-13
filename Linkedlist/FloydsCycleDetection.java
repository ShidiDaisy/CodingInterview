package Linkedlist;
/*Detect the cycle in a linkedlist
 * Use two pointers, which move through the sequence at different speeds. The idea is to move fast
 * pointer twice as quickly as the slow pointer. The distance between them increases by 1 each step.
 * If at some point they meet -> found a cycle
 * else if we have reached the end of the list -> no cycle present*/

//class Node defined in CycleDetectionByHashing.java
public class FloydsCycleDetection {
	public static void main(String[] args) {
		int[] keys = {1, 2, 3, 4, 5};
		Node head = null;
		for(int i=keys.length-1; i>=0; i--) {
			head = new Node(keys[i], head);
		}
		
		//insert cycle
		head.nextNode.nextNode.nextNode.nextNode.nextNode = head.nextNode.nextNode;
		
		if(floydsCycleDetection(head)) {
			System.out.println("Cycle Found");
		}else {
			System.out.println("No Cycle Found");
		}
	}
	
	public static boolean floydsCycleDetection(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.nextNode != null) {
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
			
			//check if they meet
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
		
	}
}
