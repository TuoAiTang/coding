

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> hp = new PriorityQueue<>(
            (Integer a, Integer b) -> hm.get(a) - hm.get(b)
        );
        for(int num : hm.keySet()){
            hp.offer(num);
            if(hp.size() > k)
                hp.poll();
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!hp.isEmpty()){
            res.addFirst(hp.poll());
        }
        return res;
    }
}