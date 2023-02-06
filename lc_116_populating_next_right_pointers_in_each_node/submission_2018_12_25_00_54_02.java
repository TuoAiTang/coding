

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
        	int size = q.size();
        	while(size-- > 0){
        		TreeLinkNode n = q.remove();
        		n.next = size == 0 ? null : q.peek();
        		if(n.left != null)
        			q.add(n.left);
        		if(n.right != null)
        			q.add(n.right);
        	}
        }
    }
}