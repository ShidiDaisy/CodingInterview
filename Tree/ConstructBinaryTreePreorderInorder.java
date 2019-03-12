package Tree;

import java.util.Stack;

/*Give preorder and inorder traversal of a tree, construct the binary tree
 * Example 1:
	Input:  [], []
	Output: null  


Example 2:
	Input: in-order = [1,2,3], pre-order = [2,1,3]
	Output:  
	
	  2
	 / \
	1   3*/
public class ConstructBinaryTreePreorderInorder {

	public static void main(String[] args) {
		int[] preorder = {1,2,3};
		int[] inorder = {2,1,3};
		TreeNode root = buildTree(preorder, inorder);
		System.out.println("");
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder){
		if(preorder.length != inorder.length){
			return null;
		}
		return 	myBuildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
	}
	
	public static TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend){
		if(instart > inend){
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[prestart]);
		int rootPosition = findPos(inorder, instart, inend, preorder, prestart);
		root.left = myBuildTree(inorder, instart, inend-1, preorder, prestart+1, prestart+rootPosition-instart);
		root.right = myBuildTree(inorder, rootPosition+1, inend, preorder, rootPosition-inend+preend + 1, preend);
		return root;
	} 
	
	public static int findPos(int[] inorder, int instart, int inend, int[] preorder, int prestart){
		for(int i=instart; i<=inend; i++){
			if(inorder[i] == preorder[prestart]){
				return i;
			}
		}
		return -1;
	}

}
