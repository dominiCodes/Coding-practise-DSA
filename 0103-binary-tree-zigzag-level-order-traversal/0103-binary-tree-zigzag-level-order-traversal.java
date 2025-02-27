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
    // Algo Used: 100% same as Level order traversal
    // Modifications done were introdunced a flag variable, 0 - means asc and 1 - means desc
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int flag= 0;
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        List<List<Integer>> ans= new ArrayList<>();
        if(root == null) return ans;
        queue.offer(root);  // add root in queue
        while(!queue.isEmpty()){
            int currLevel= queue.size();
            List<Integer> temp= new ArrayList<>();
            for(int i=0; i< currLevel; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);  // if curr has any left than add in queue
                if(queue.peek().right != null) queue.offer(queue.peek().right); // if curr has any right than add in queue
                temp.add(queue.poll().val);  // poll will add the curr val in queue and will remove from queue as well 
            }
            if(flag % 2 == 0){     // asc order
                ans.add(temp);
            }else{
                Collections.reverse(temp);      // desc order
                ans.add(temp);
            }
            flag++;     // after inserting temp increase the flag
        }
        return ans;
    }
}