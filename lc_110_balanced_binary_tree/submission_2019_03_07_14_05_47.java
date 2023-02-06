

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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return balanced;
    }
    
    public int depth(TreeNode root){
        if(root == null) return -1;
        int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(right - left) > 1){
            balanced =  false;
            return -1; //-1 or any value, doesn't matter, assp return
        }
            
        return Math.max(left, right) + 1;
    }
}