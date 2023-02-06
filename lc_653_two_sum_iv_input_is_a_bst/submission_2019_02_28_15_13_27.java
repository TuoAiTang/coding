

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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> li = new ArrayList<>();
        inorder(root, li);
        int l = 0, r = li.size() - 1;
        while(l < r){
        	int sum = li.get(l) + li.get(r);
        	if(sum == k)
        		return true;
        	if(sum < k)
        		l++;
        	else
        		r--;
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> li){
    	if(root != null){
    		inorder(root.left, li);
    		li.add(root.val);
    		inorder(root.right, li);
    	}
    }
}