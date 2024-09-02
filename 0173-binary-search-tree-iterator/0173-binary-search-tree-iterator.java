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
// SC: O H 
// TC: O 1 (for taking nnextEle and hasNext)
 // Easy peasy haii (see striver dry run for 2 min if required)
class BSTIterator {
    private Stack<TreeNode> stack= new Stack<TreeNode>();

    public BSTIterator(TreeNode root) { // as soon as we start , we will go to the extreme left as per the inorder
        pushAllLeft(root);
    }
    
    public int next() { // we will be returning the node over here and it will be done as per inorder
        TreeNode node= stack.pop();
        pushAllLeft(node.right);    // if the node has right element then it will push all the left of the right node
        return node.val;
    }
    
    public boolean hasNext() {  // if stack is not empty means there is a next element present so return true or return false
        return !stack.isEmpty();
    }

    public void pushAllLeft(TreeNode node){ // is will pushh all thhe node.left in the stack
        while(node!= null){
            stack.push(node);
            node= node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */