

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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty() && q.peek() != null){
        	TreeNode t = q.remove();
        	q.add(t.left);
        	q.add(t.right);       	
        }

        while(!q.isEmpty())
        	if(q.remove() != null)
        		return false;
    	return true;
    }
}