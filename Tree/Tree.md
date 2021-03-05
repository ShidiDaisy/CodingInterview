## [Convert a Binary Tree into its Mirror Tree](https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/)
### Recursive
1. Mirror(left-subtree)
2. Mirror(right-subtree)
3. Swap left and right subtrees 
   * temp = left-subtree
   * left-subtree = right-subtree
   * right-subtree = temp 
   
