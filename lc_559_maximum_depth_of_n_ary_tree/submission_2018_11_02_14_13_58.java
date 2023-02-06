

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
    public int maxDepth(Node root) {
        if(root == null)
        	return 0;
        int max = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
        	int size = que.size();
        	for (int i = 0; i < size; i++) {
				Node cur = que.poll();
				for (Node node : cur.children) {
					que.offer(node);
				}
			}
        	max++;
        }
        return max;
	}
}