package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Writing the tree to a file is called 'serialization' and reading back from the file to 
 * reconstruct the exact same binary tree is 'deserialization'.
 * 
 * Example 1:

Input:
Binary tree {3,9,20,#,#,15,7},  denote the following structure:
	  3
	 / \
	9  20
	  /  \
	 15   7

Example 2:

Input:
Binary tree {1,2,3},  denote the following structure:
   1
  / \
 2   3*/
public class SerializeDeserializeBinaryTree {

	public static void main(String[] args) {
		String data = "{1,2,3}";
		System.out.println(serialize(deserialize(data)));
	}
	
	public static String serialize(TreeNode root) {
		if(root==null) {
			return "{}";
		}
		
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		nodeList.add(root);
		
		for(int i=0; i<nodeList.size(); i++) {
			if(nodeList.get(i) == null) {
				continue;
			}
			nodeList.add(nodeList.get(i).left);
			nodeList.add(nodeList.get(i).right);
		}
		
		//remove the null nodes (#) at the end
		while(nodeList.get(nodeList.size()-1) == null) {
			nodeList.remove(nodeList.size()-1);
		}
		
		//Write the result to string
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(nodeList.get(0).val);
		for(int i=1; i<nodeList.size(); i++) {
			if(nodeList.get(i) != null) {
				sb.append(",");
				sb.append(nodeList.get(i).val);
			}else {
				sb.append(",#");
			}
		}
		sb.append("}");
		return sb.toString(); 
	}
	
	public static TreeNode deserialize(String data) {
		if(data.equals("{}")) {
			return null;
		}
		
		String[] vals = data.substring(1, data.length()-1).split(",");
		Queue<TreeNode> NodeList = new LinkedList<TreeNode>();
		
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		NodeList.add(root);
		
		boolean isLeftChild = true;
		TreeNode motherNode = NodeList.poll();
		for(int i=1; i<vals.length; i++) {
			if(!vals[i].equals("#")) {
				TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
				if(isLeftChild) {
					motherNode.left = node;
				}else {
					motherNode.right = node;
				}
				NodeList.add(node);
			}
			
			isLeftChild = !isLeftChild;
			if(isLeftChild) {
				motherNode = NodeList.poll();
			}
		}
		return root;
	}
}
