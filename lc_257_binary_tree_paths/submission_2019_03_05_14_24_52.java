

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
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);

        Stack<String> s2 = new Stack<>();
        s2.push("");


        while(!s1.isEmpty()){
        	TreeNode p = s1.pop();
        	String path = s2.pop() + p.val;
        	if(p.right == null && p.left == null)
        		res.add(path);
        	else{
        		path += "->";
        		if(p.right != null){
        			s1.push(p.right);
        			s2.push(path);
        		}
        		if(p.left != null){
        			s1.push(p.left);
        			s2.push(path);
        		}
        	}
        }
        return res;
    }
}