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
class Solution {
    List<Integer>result = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
    inorder(root);
    return result;
    } // main class
    TreeNode inorder(TreeNode root){
        if(root==null)  return null;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    return root;
    
}}