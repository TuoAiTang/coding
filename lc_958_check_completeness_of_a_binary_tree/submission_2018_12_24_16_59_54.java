

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
    class Pair{
		boolean is_complete;
		int height;
		Pair(boolean is_c, int h) {is_complete = is_c;  height = h; }
	}
    public boolean isCompleteTree(TreeNode root) {
        return helper(root).height != -1;
    }

    private Pair helper(TreeNode t){
    	if(t == null) return new Pair(true, 0);
    	Pair left = helper(t.left);
    	Pair right = helper(t.right);
    	if(left.height < 0 || right.height < 0) return new Pair(false, -1);
    	if(right.height > left.height || 
    		(right.height == left.height && !left.is_complete) || 
    		left.height - right.height > 1)
    		return new Pair(false, -1);
    	if(left.height > right.height && !right.is_complete) return new Pair(false, -1);
    	int height = Math.max(left.height, right.height) + 1;
    	return new Pair(left.height > right.height ? false : left.is_complete && right.is_complete, height);
    }
}