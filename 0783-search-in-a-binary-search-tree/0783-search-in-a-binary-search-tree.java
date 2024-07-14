/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Note: BST propert is , nodes on left sub tree will always be small, node on right sub tree will always be large
 // There will be no duplicates
 // Easy Peasy code
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val){
                return root;
            }

            if(val < root.val){
              root= root.left;
            }else{
              root= root.right;
             }
        }  
        return root; 
    }
}