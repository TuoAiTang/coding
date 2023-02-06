

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
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        helper(root, sum, path);
        return paths;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> path){
        if(root == null) return;
        path.add(root.val);
        
        if(root.val == sum && root.left == null && root.right == null)
            paths.add(new ArrayList<>(path));
        
        helper(root.left, sum - root.val, new ArrayList<>(path));
        helper(root.right, sum - root.val, new ArrayList<>(path));
    }
}