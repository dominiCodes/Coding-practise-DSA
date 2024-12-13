/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int ans = 0;
    int res = 0;
    public int maxDepth(Node root) {
        if (root == null) {return 0;}
        helper(root);
        return res+1;
    }
    public void helper (Node root) {
        if (root == null) {
            return;
        }
        
        if (root.children.size() > 0) {
            ans++;
            res = Math.max(res,ans);
            for (Node n:root.children) {
                helper(n);
            }
            ans--;
        }
        
    }
}