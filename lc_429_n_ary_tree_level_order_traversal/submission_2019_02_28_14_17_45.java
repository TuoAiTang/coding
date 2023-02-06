

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
    	if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
        	int size = q.size();
        	List<Integer> level = new ArrayList<>();
        	while(size -- > 0){
        		Node cur = q.remove();
        		level.add(cur.val);
        		for(Node child : cur.children)
        			q.offer(child);
        	}
        	res.add(level);
        }
        return res;
    }
}