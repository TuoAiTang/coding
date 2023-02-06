

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

    public List<Integer> preorder(Node root) {
    	List<Integer> li = new ArrayList<>();
    	preorder(root, li);
    	return li;
    }

    public void preorder(Node root, List<Integer> li){
    	if(root == null)
    		return;
    	li.add(root.val);
    	for(Node n : root.children)
    		preorder(n, li);
    }
}