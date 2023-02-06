

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
    public int diameterOfBinaryTree(TreeNode root) {
        oneSideDiameter(root);
        return ans;
    }

    public int oneSideDiameter(TreeNode root){
    	if(root == null) return -1;
        int left = oneSideDiameter(root.left);
        int right = oneSideDiameter(root.right);
        ans = Math.max(ans, left + right + 2);
        return Math.max(left, right) + 1;
    }
}