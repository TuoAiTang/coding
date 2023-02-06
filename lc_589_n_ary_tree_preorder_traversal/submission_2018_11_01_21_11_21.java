

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
        List<Integer> res = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        if(root == null)
        	return res;
        stk.push(root);
        while(!stk.isEmpty()) {
        	Node p = stk.pop();
        	res.add(p.val);
        	int size = p.children.size();
        	for (int i = size - 1; i >= 0; i--) 
        		stk.push(p.children.get(i));       	
        }
        return res;  
    }
}