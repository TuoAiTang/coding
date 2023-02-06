

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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return ans;
    }
    
    //return the longest path with root.val
    //one side
    public int helper(TreeNode root){
        if(root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int ret_l = 0;
        int ret_r = 0;
        if(root.left != null && root.left.val == root.val)
            ret_l = l + 1;
        if(root.right != null && root.right.val == root.val)
            ret_r = r + 1;
        ans = Math.max(ans, ret_l + ret_r);
        return Math.max(ret_l, ret_r);
    }
}