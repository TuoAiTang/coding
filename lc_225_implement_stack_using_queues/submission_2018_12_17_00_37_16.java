

class MyStack {

	private Queue<Integer> q;
    /** Initialize your data structure here. */
    public MyStack() {
       	q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	int size = q.size();
    	q.add(x);
    	while(size-- > 0)
    		q.add(q.remove());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(empty()) return -1;
    	return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
    	if(empty()) return -1;
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
    	
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */