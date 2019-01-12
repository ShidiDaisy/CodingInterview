package Linkedlist;
/*Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
Write a function flatten() to flatten the lists into a single linked list. The flattened linked list 
should also be sorted. For example, for the above input list, output list should be 
5->7->8->10->19->20->22->28->30->35->40->45->50.

hint: Merge() in MergeSort()
*/
public class FlattenLinkedList {
	
	Node head;
	class Node 
    { 
        int data; 
        Node right, down; 
        Node(int data) 
        { 
            this.data = data; 
            right = null; 
            down = null; 
        } 
    } 
	
	Node merge(Node a, Node b){
		Node res;
		if(a == null){
			return b;
		}
		
		if(b == null){
			return a;
		}
		
		if(a.data < b.data){
			res = a;
			res.down = merge(a.down, b);
		}else{
			res = b;
			res.down = merge(a, b.down);
		}
		
		return res;
	}
	
	/*return the head node of sorted linked list
	 * */
	Node flatten(Node root){
		//Base case
		if(root != null && root.right == null){
			return root;
		}

		//Recursive merge the list from right to left
		root.right = flatten(root.right);
		root = merge(root, root.right);
		
		return root;
		
	}
	
	Node push(Node head_ref, int data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(data); 
  
        /* 3. Make next of new Node as head */
        new_node.down = head_ref; 
  
        /* 4. Move the head to point to new Node */
        head_ref = new_node; 
  
        /*5. return to link it back */
        return head_ref; 
    } 
  
    void printList() 
    { 
        Node temp = head; 
        while (temp != null) 
        { 
            System.out.print(temp.data + " "); 
            temp = temp.down; 
        } 
        System.out.println(); 
    } 
  
	public static void main(String[] args) {
		FlattenLinkedList L = new FlattenLinkedList(); 
		  
        /* Let us create the following linked list 
            5 -> 10 -> 19 -> 28 
            |    |     |     | 
            V    V     V     V 
            7    20    22    35 
            |          |     | 
            V          V     V 
            8          50    40 
            |                | 
            V                V 
            30               45 
        */
  
        L.head = L.push(L.head, 30); 
        L.head = L.push(L.head, 8); 
        L.head = L.push(L.head, 7); 
        L.head = L.push(L.head, 5); 
  
        L.head.right = L.push(L.head.right, 20); 
        L.head.right = L.push(L.head.right, 10); 
  
        L.head.right.right = L.push(L.head.right.right, 50); 
        L.head.right.right = L.push(L.head.right.right, 22); 
        L.head.right.right = L.push(L.head.right.right, 19); 
  
        L.head.right.right.right = L.push(L.head.right.right.right, 45); 
        L.head.right.right.right = L.push(L.head.right.right.right, 40); 
        L.head.right.right.right = L.push(L.head.right.right.right, 35); 
        L.head.right.right.right = L.push(L.head.right.right.right, 20); 
  
        // flatten the list 
        L.head = L.flatten(L.head); 
  
        L.printList(); 

	}

}
