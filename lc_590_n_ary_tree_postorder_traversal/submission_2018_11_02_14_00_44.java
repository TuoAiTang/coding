

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
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
		helper(res, root);
		return res;
    }
    void helper(LinkedList<Integer> res, Node root) {
		if(root == null)
			return;
		for (Node node : root.children) {
			helper(res, node);
		}
		res.add(root.val);	
	}
}