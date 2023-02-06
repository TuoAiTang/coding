

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key)
            root.left = deleteNode(root.left, key);
        else if(root.val < key)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            
            //root.left != null && root.right != null
            //find the smallest node of right-subtree
            
            TreeNode s = root.right;
            while(s.left != null)
                s = s.left;
            
            root.val = s.val;
            root.right = deleteNode(root.right, s.val); 
        }    
        return root;
    } 
    
}