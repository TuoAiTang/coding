

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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSideSum(root);
        return ans;
    }
    
    //return largest one side path sum
    //contains root
    public int oneSideSum(TreeNode root){
        if(root == null) return 0;
        int left = oneSideSum(root.left);
        int right = oneSideSum(root.right);
        if(left < 0 && right < 0){
            ans = Math.max(ans, root.val);
            return root.val;
        }
        
        int bigger_one = Math.max(left, right);
        
        if(left > 0 && right > 0)
            ans = Math.max(ans, root.val + left + right);
    
        else
            ans = Math.max(ans, bigger_one + root.val);
        
        return bigger_one + root.val;       
    }
}