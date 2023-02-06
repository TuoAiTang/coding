

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
	int tilt = 0;
    public int findTilt(TreeNode root) {
        treeSum(root);
        return tilt;
    }

    public int treeSum(TreeNode root){
    	if(root == null)
    		return 0;
    	int left = treeSum(root.left);
    	int right = treeSum(root.right);
    	tilt += Math.abs(left - right);
    	return left + root.val + right;
    }
}