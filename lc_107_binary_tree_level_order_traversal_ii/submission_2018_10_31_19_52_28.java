

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
   public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null)
        	return res;
        que.offer(root);
        while(!que.isEmpty()) {
        	int levelSize = que.size();
        	List<Integer> levelList = new ArrayList<>();
        	while(levelSize-- > 0) {
        		TreeNode t = que.poll();      		
        		levelList.add(t.val);
            	if(t.left != null)
            		que.offer(t.left);
            	if(t.right != null)
            		que.offer(t.right);           	
        	}
        	res.addFirst(levelList);
        }                      
        return res;
    }
}