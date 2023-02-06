

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
    TreeNode orgRoot;
    public boolean findTarget(TreeNode root, int k) {
        orgRoot = root;
        return dfs(root, k);
    }

    public boolean dfs(TreeNode root, int k){
    	if(root == null) return false;
    	if(find(orgRoot, k - root.val, root)) return true;
    	return dfs(root.left, k) || dfs(root.right, k);
    }

    public boolean find(TreeNode root, int val, TreeNode ref){
    	if(root == null) return false;
    	if(root.val == val && root != ref)
    		return true;
    	if(root.val < val)
    		return find(root.right, val, ref);
    	else
    		return find(root.left, val, ref);
    }
}