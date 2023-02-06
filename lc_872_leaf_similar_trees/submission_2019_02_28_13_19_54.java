

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        leaves(root1, l1);
        leaves(root2, l2);
        if(l1.size() != l2.size())
        	return false;
        for(int i = 0; i < l1.size(); i ++)
        	if(l1.get(i) != l2.get(i))
        		return false;
        return true;
    }

    public void leaves(TreeNode root, List<Integer> li){
    	if(root == null) return;
    	leaves(root.left, li);
    	if(root.left == null && root.right == null)
    		li.add(root.val);
    	leaves(root.right, li);
    }
}