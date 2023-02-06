

class MedianFinder {
	//a is less than b
	PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(
    		new Comparator<Integer>() {
    			@Override
    			public int compare(Integer a, Integer b) {
    				return a - b < 0 ? 1 : -1;
    			}
    			
    		});
	//a is greater than b
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>(
    		new Comparator<Integer>() {
    			@Override
    			public int compare(Integer a, Integer b) {
    				return a - b > 0 ? 1 : -1;
    			}    			
    		});
    /** initialize your data structure here. */
    public MedianFinder() {
   
    }
    
    public void addNum(int num) {
        //add
        if(leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek())
        	leftMaxHeap.offer(num);
        else
        	rightMinHeap.offer(num);
        //balance the left and right
        if(leftMaxHeap.size() < rightMinHeap.size())
        	leftMaxHeap.offer(rightMinHeap.poll());
    	else if(leftMaxHeap.size() - rightMinHeap.size() == 2)
        	rightMinHeap.offer(leftMaxHeap.poll());
        
    }
    
    public double findMedian() {
        if(leftMaxHeap.size() == rightMinHeap.size())
        	return (double)(leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        else
        	return (double)(leftMaxHeap.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */