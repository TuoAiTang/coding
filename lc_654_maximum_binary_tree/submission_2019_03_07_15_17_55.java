

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums, int l, int r){
        if(l > r) return null;
        int mi = maxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[mi]);
        root.left = constructMaximumBinaryTree(nums, l, mi - 1);
        root.right = constructMaximumBinaryTree(nums, mi + 1, r);
        return root;
    }
    
    public int maxIndex(int [] nums, int l, int r){
        int index = r;
        int maxVal = nums[r];
        for(int i = l; i < r; i++){
            if(nums[i] > maxVal){
                index = i;
                maxVal = nums[i];
            }
        }
        return index;
    }
}