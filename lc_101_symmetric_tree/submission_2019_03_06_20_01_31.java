

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
        while(!q.isEmpty()){
            TreeNode x = q.poll();
            TreeNode y = q.poll();
            if(x == null && y == null) continue;
            if(x == null || y == null) return false;
            if(x.val != y.val) return false;
            q.offer(x.left);
            q.offer(y.right);
            q.offer(x.right);
            q.offer(y.left);
        }
        return true;
    }
}