

class MedianFinder {
    
    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;

    /** initialize your data structure here. */
    public MedianFinder() {
        leftMax = new PriorityQueue<>((a, b) -> b - a);
        rightMin = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMax.isEmpty() || num < leftMax.peek())
            leftMax.offer(num);
        else
            rightMin.offer(num);
        
        if(leftMax.size() < rightMin.size())
            leftMax.offer(rightMin.poll());
        
        if(leftMax.size() - rightMin.size() > 1)
            rightMin.offer(leftMax.poll());
    }
    
    public double findMedian() {
        if(leftMax.isEmpty())
            return 0.0;
        if(leftMax.size() == rightMin.size())
            return (leftMax.peek() + rightMin.peek()) / 2.0;
        return leftMax.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */