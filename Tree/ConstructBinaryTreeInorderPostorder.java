
public class ConstructBinaryTreeInorderPostorder {
    /*Given inorder and postorder traversal of a tree, construct the binary tree.
    * Example 1:

    Input:
    [1,2]
    [2,1]
    Output:
    {1,#,2}
    Explanation:
        1
         \
          2

    Example 2:

    Input:
    [1,2,3]
    [1,3,2]
    Output:
    {2,1,3}
    Explanation:
      2

     /  \

    1    3

    Assume:
    No same number in the tree

    HINT:
    Root will be the last node to visit, so the last element in postorder list is root.
    Match the root in the inorder list. Recursively do the same to the left subtree and right subtree
*/
    public static void main(String[] args){
        int[] inorder = {1, 2};
        int[] postorder = {2, 1};
        buildTree(inorder, postorder);
        System.out.println("");
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder.length != postorder.length){
            return null;
        }else {
            return myBuildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        }

    }

    public static TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
        if(instart > inend){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);

        //find the position in inorder list
        int position = findPosition(inorder, instart, inend, postorder[postend]);

        //traverse the left subtree and right subtree
        root.left = myBuildTree(inorder, 0, position-1, postorder, 0, position-1);
        root.right = myBuildTree(inorder, position+1, inend, postorder, position-1, postend);
        return root;
    }

    public static int findPosition(int[] arr, int start, int end, int key){
        for (int i = start; i <= end; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
