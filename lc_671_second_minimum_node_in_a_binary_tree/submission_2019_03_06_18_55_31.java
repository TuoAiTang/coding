

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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        if(root.left == null)
            return findSecondMinimumValue(root.right);
        if(root.right == null)
            return findSecondMinimumValue(root.left);
        if(root.left.val == root.right.val){
            int lt = findSecondMinimumValue(root.left);
            int rt = findSecondMinimumValue(root.right);

            if(lt == -1)
                return rt;
            if(rt == -1)
                return lt;
            return Math.min(rt, lt);

        }
        if(root.left.val == root.val){
            int lt = findSecondMinimumValue(root.left);
            return lt == -1 ? root.right.val : Math.min(lt, root.right.val);
        }
        else{
            int rt = findSecondMinimumValue(root.right);
            return rt == -1 ? root.left.val : Math.min(rt, root.left.val);
        }         
    }
}