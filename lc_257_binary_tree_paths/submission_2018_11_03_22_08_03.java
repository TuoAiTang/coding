

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
        Stack<TreeNode> stk = new Stack<>();
        List<String> res = new LinkedList<String>();
        Stack<String> str_stk = new Stack<>();
        if(root == null)
        	return res;
        stk.push(root);
        str_stk.push("");
        while(!stk.isEmpty()) {
        	TreeNode t = stk.pop();
        	String path = str_stk.pop() + t.val;
        	if(t.right == null && t.left == null)
        		res.add(path);
        	
    		path += "->";
    		
        	if(t.right != null) {
        		str_stk.push(path);
        		stk.push(t.right);
        	}
        	if(t.left != null) {
        		str_stk.push(path);
        		stk.push(t.left);
        	}     	
        }      
        return res;	
    }
}