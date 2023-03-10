

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
        while(root != null){
        	TreeLinkNode cur = root;
        	while(cur != null){
        		if(cur.left != null) cur.left.next = cur.right;
        		if(cur.right != null) cur.right.next = cur.next == null ? null : cur.next.left;
        		cur = cur.next;
        	}
        	root = root.left;
        } 	        
    }
}