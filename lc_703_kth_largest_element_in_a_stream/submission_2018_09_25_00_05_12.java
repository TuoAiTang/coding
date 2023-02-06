

class KthLargest {

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); 
    int size = 0;
    public KthLargest(int k, int[] nums) {
        size = k;
        for(int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        if(queue.size() > size) queue.poll();
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */