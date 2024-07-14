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

 // Note: What helper function do is when we reach at the node which we want to delete, we will pass that node to helper,
 // the helper will do the re-allocation of using the rightChild and RighMostOfLeftSubChild (view striver dry dun)
 // Baki easy peasy hai
 // TC: O H , SC: O 1
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key) return helper(root); // it means we have to delete the main root, directly pass that to helper

        TreeNode curr = root;

        while(curr != null) { // running the loop
            if(curr.val > key) {
                if(curr.left != null && curr.left.val == key) { // got key so passing to helper
                    curr.left = helper(curr.left);
                }
                else curr = curr.left;  // keep moving until finds the key
            }

            else {
                if(curr.right != null && curr.right.val == key) { // got key so passing to helper
                    curr.right = helper(curr.right);
                }
                else curr = curr.right;     // keep moving until finds the key
            }
        }

        return root; // retunr the main root which was stored in temp
    }

    public TreeNode helper(TreeNode root) {
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastRight = findLast(root.left);
        lastRight.right = root.right;
        return root.left; // root it deleted so returning the left one, of which the rightMostChild is connected to root.right
    }

    public TreeNode findLast(TreeNode root) {
        while(root.right != null) root = root.right;
        return root;
    }
}