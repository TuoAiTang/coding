

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
    	if(root == null)
    		return li;
    	Stack<Node> stk = new Stack<>();
    	stk.push(root);
    	while(!stk.isEmpty()){
    		Node cur = stk.pop();
    		li.add(cur.val);
    		int size = cur.children.size();
    		for(int i = size - 1; i >= 0; i --)
    			stk.push(cur.children.get(i));
    	}
    	return li;
    }
}