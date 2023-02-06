

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
        Stack<Node> stk = new Stack<>();
        if(root == null)
        	return res;
        stk.push(root);
        while(!stk.isEmpty()){
        	Node cur = stk.pop();
        	res.addFirst(cur.val);
        	for(Node child : cur.children)
        		stk.push(child);
        }
        return res;
    }
}