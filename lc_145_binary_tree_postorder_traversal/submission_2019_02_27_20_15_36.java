

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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stk = new Stack<>();
        if(root == null)
        	return res;
        stk.push(root);
        while(!stk.isEmpty()){
        	TreeNode cur = stk.pop();
        	res.addFirst(cur.val);
        	if(cur.left != null)
        		stk.push(cur.left);
        	if(cur.right != null)
        		stk.push(cur.right);
        }
        stk.push(root);
        return res;
    }
}