

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, Math.max(p.val, q.val), Math.min(p.val, q.val));
    }

    public TreeNode helper(TreeNode root, int max, int min){
    	if(root == null) return root;
    	if(root.val > max)
    		return helper(root.left, max, min);
    	if(root.val < min)
    		return helper(root.right, max, min);
    	return root;
    }
}