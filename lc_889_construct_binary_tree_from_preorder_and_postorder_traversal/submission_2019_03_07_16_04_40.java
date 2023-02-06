

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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
       return helper(pre, post, 0, 0, pre.length); 
    }
    
    public TreeNode helper(int[] pre, int[] post, int pre_start, int post_start, 
                          int length){
        if(length <= 0) return null;
        TreeNode root = new TreeNode(pre[pre_start]);
        if(length == 1)
            return root;
        int rootIndexOfPost = post_start;
        while(post[rootIndexOfPost] != pre[pre_start + 1])
            rootIndexOfPost ++;
        int new_len = rootIndexOfPost - post_start + 1;
        root.left = helper(pre, post, pre_start + 1, post_start, new_len);
        root.right = helper(pre, post, pre_start + new_len + 1,
                           rootIndexOfPost + 1, length - new_len - 1);
        return root;     
    }
}