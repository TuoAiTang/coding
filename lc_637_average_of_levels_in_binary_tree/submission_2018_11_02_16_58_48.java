

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        if(root == null)
        	return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {        	
        	int size = que.size();
        	long sum = 0;
        	int n = size;
        	while(n-- > 0) {
        		TreeNode cur = que.remove();
        		sum += cur.val;
        		if(cur.left != null)
        			que.offer(cur.left);
        		if(cur.right != null)
        			que.offer(cur.right);
        		
        	}
        	res.add((double)sum / size);       	
        }       
        return res;
    }
}