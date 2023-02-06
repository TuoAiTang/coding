

class MyCircularQueue {

    int [] q;
    int size;
    int front;
    int rear;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        q = new int [k + 1];
        front = 0;
        rear = 1;
        size = k + 1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) return false;
        q[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front + 1) % size;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        int index = (front + 1) % size;
        return q[index];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;
        int index = (rear - 1 + size) % size;
        return q[index];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        int index = (front + 1) % size;
        return index == rear;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return front == rear;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */