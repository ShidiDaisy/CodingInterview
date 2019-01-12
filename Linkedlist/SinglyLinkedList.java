package Linkedlist;

public class SinglyLinkedList {

	Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	//Find the middle of a given linked list
	void printMiddle(){
		/*Two pointers, one point to the cur node, one pointer to cur*2 position. 
		 * Iterate the element in the list, when cur*2 reach the end, cur is the middle position */
		
		Node end_ptr = head;
		Node middle_ptr = head;
		if(head != null){
			while(end_ptr != null && end_ptr.next != null){
				middle_ptr = middle_ptr.next;
				end_ptr = end_ptr.next.next;
			}
			
			System.out.println("The middle element is [" + middle_ptr.data + "] \n");
		}
	}
	
	//Insert new node in front
	public void push(int new_data){
		
		Node new_node = new Node(new_data);
		
		//Add the old head as the successor of new_node
		new_node.next = head;
		
		//Update the new_node as new head
		head = new_node;
	}
	
	public void printList(){
		Node curNode = head;
		while(curNode != null){
			System.out.print(curNode.data + "->");
			curNode = curNode.next;
		}
		System.out.println("NULL");
	}
	
	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList();
		for(int i=5; i>0; i--){
			ll.push(i);
			ll.printList();
			ll.printMiddle();
		}
	}

}
