

class MyStack {

	private Queue<Integer> q1;
	private Queue<Integer> q2;
	private int top;
    /** Initialize your data structure here. */
    public MyStack() {
       	q1 = new LinkedList<>();
       	q2 = new LinkedList<>();  
       	top = -1;     
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	q2.add(x);
    	top = x;
        while(!q1.isEmpty())
    		q2.add(q1.remove());
    	Queue<Integer> tmp = q1;
    	q1 = q2;
    	q2 = tmp;

    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(empty()) return -1;
    	int pop_num = q1.remove();
    	return pop_num;
    }
    
    /** Get the top element. */
    public int top() {
    	if(empty()) return -1;
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
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