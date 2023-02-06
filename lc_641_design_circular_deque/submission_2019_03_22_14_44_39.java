

class MyCircularDeque {
    
    int [] q;
    int size;
    int front;
    int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        q = new int[k + 1];
        size = k + 1;
        front = 0;
        rear = 1;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        q[front] = value;
        front = (front - 1 + size) % size;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        q[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front + 1) % size;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear - 1 + size) % size;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        int index = (front + 1) % size;
        return q[index];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        int index = (rear - 1 + size) % size;
        return q[index];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        int index = (front + 1) % size;
        return index == rear;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return front == rear;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */