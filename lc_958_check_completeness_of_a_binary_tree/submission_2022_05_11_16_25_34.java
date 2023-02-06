

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
        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty() && q.peek() != null){
            TreeNode p = q.poll();
            q.offer(p.left);
            q.offer(p.right);
        }
        
        while(!q.isEmpty())
            if(q.poll() != null)
                return false;
        
        return true;
    }
}