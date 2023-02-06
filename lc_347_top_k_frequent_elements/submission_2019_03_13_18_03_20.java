

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        
        Map<Integer, List<Integer>> bucket = new HashMap<>();
        int max_freq = 1;
        
        //<num, freq>
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
            max_freq = Math.max(max_freq, count.get(num));
        }
        
        for(int num : count.keySet()){
            if(!bucket.containsKey(count.get(num)))
                bucket.put(count.get(num), new ArrayList<>());
            bucket.get(count.get(num)).add(num);
        }
        
        for(int i = max_freq; i > 0; i--){
            if(ans.size() == k) return ans;
            if(bucket.get(i) != null){
                ans.addAll(bucket.get(i));
            }
        }
        
        return ans;
    }
}