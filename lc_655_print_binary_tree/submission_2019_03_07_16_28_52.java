

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
    public List<List<String>> printTree(TreeNode root) {
        int m = depth(root);
        int n = (1 << m) - 1;
        List<List<String>> res = new ArrayList<>();
        
        
        String[][] arr = new String[m][n];
        for(String[] a : arr)
            Arrays.fill(a, "");
        
        fill(arr, root, 0, 0, n - 1);
        
        for(String[] a : arr)
            res.add(Arrays.asList(a));
        
        return res;
        
    }
    
    public void fill(String[][] arr, TreeNode root, int level, int l, int r){
        if(root == null) return;
        int mid = (l + r) / 2;
        arr[level][mid] = root.val + "";
        fill(arr, root.left, level + 1, l, mid - 1);
        fill(arr, root.right, level + 1, mid + 1, r);
    }
    
    public int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}