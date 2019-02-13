package Linkedlist;

import java.util.HashSet;
import java.util.Set;

/*Detect a cycle in LinkedList by using hashing
 * - Traverse the given LinkedList and insert each encountered node into a set. If current node is 
 * already inside the set, that means there is a cycle*/

class Node{
	int data;
	Node nextNode;
	Node(int data, Node nextNode){
		this.data = data;
		this.nextNode = nextNode;
	}
}

public class CycleDetectionByHashing {

	public static void main(String[] args) {
		int[] keys = {1, 2, 3, 4, 5};
		Node head = null;
		for(int i=keys.length-1; i>=0; i--){
			head = new Node(keys[i], head);
		}
		
		//insert cycle
		head.nextNode.nextNode.nextNode.nextNode = head.nextNode.nextNode;
		
		if(detectCycle(head)){
			System.out.println("Cycle detected");
		}else{
			System.out.println("No cycle detected");
		}

	}

	private static boolean detectCycle(Node head) {
		Node curr = head;
		Set<Node> set = new HashSet<Node>();
		
		while(curr != null){
			if(!set.contains(curr)){
				set.add(curr.nextNode);
				curr = curr.nextNode;
			}else{
				return true;
			}
		}
		return false;
	}

}
