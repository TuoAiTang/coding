

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
            
            TreeNode parent = root;
            TreeNode new_root = root.right;
            while(new_root.left != null){
                parent = new_root;
                new_root = new_root.left;
            }
            
            if(parent != root){
                parent.left = new_root.right;
                new_root.right = root.right;
            }
            new_root.left = root.left;
            return new_root; 
        }    
        return root;
    } 
    
}