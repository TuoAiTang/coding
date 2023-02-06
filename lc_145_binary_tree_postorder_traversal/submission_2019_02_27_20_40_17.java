

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
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stk = new Stack<>();
        if(root == null)
        	return res;
        stk.push(root);
        TreeNode pLast = root, pCur = root;
        while(!stk.isEmpty()){
        	pCur = stk.peek();
        	if(pCur.left != null && pLast != pCur.right && pLast != pCur.left)
        		stk.push(pCur.left);
        	else if(pCur.right != null && pLast != pCur.right)
        		stk.push(pCur.right);
        	else{
        		stk.pop();
        		res.add(pCur.val);
        		pLast = pCur;
        	}
        }
        return res;
    }
}