

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()) {
        	TreeNode t1 = q.remove();
        	TreeNode t2 = q.remove();
        	if(t1 == null && t2 == null) continue;
        	if(t1 == null || t2 == null) return false;
        	if(t1.val != t2.val) return false;
        	q.add(t1.left);
        	q.add(t2.right);
        	q.add(t1.right);
        	q.add(t2.left);
        }
        return true;   
    }
}