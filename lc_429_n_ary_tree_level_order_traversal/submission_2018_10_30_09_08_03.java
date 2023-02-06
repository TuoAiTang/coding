

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null)
        	return res;
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	List<Integer> levelList = new ArrayList<>();
        	while(size != 0) {
        		Node n = q.poll();
        		levelList.add(n.val);
        		List<Node> children = n.children;
        		for(Node p : children) {
        			q.offer(p);
        		}
        		size--;
        	}
            res.add(levelList);
        }              
        return res;
    }
}