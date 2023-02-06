

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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        dis(root, target, K, ans);
        return ans;
    }
    
    //return the distance between root and the target
    public int dis(TreeNode root, TreeNode target, int k, List<Integer> ans){
        if(root == null) return -1;
        if(root == target){
            collect(ans, root, k);
            return 0;
        }
        
        int l = dis(root.left, target, k, ans);
        int r = dis(root.right, target, k, ans);
        
        //target in right subtree
        if(r >= 0){       
            if(k == r + 1) ans.add(root.val);
            collect(ans, root.left, k - r - 2);
            return  r + 1;
        }
        
        if(l >= 0){
            if(k == l + 1) ans.add(root.val);
            collect(ans, root.right, k - l - 2);
            return l + 1;
        }
        
        return -1;
    }
    
    public void collect(List<Integer> ans, TreeNode root, int d){
        if(root == null || d < 0) return ;
        if(d == 0)
            ans.add(root.val);
        collect(ans, root.left, d - 1);
        collect(ans, root.right, d - 1);
    }
}