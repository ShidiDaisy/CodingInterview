package Tree;
/*UNFINISHED
 * For traversing a (non-empty) binary tree in in-order fashion:	
 */
public class InOrderTreeTraversal {

	public static void main(String[] args) {
		//For every node N starting from root:
		TreeNode root = new TreeNode(1);
		inorder(root);
	}
	
	public static void inorder(TreeNode node) {
		//base case
		if(node == null) {
			return; 
		}
		
 		//1. Recursively traverse its left subtree. When this step finished we back at N again.
		inorder(node.left);
		//2. Process N itself
		System.out.println(node.val + "->");
		//3. Recursively traverse its right subtree. When this step finished we back at N again
		inorder(node.right);
	}
}
