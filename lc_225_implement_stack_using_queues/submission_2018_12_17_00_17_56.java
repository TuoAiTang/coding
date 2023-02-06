

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
        q1.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	while(q1.size() > 1){
    		top = q1.remove();
    		q2.add(top);
    	}
    	int pop_num = q1.remove();
    	Queue<Integer> tmp = q1;
    	q1 = q2;
    	q2 = tmp;
    	return pop_num;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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