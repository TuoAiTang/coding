

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        int max_freq = 1;
        
        List<String> ans = new ArrayList<>();
        for(String word : words){
            counts.put(word, counts.getOrDefault(word, 0) + 1);
            max_freq = Math.max(max_freq, counts.get(word));
        }
        
        List [] buckets = new List [max_freq + 1];
           
        for(String word : counts.keySet()){
            int i = counts.get(word);
            if(buckets[i] == null)
                buckets[i] = new ArrayList<String>();
            buckets[i].add(word);
        }
        
        for(int i = max_freq; i > 0; i --){
            if(buckets[i] == null) continue;
            int need = k - ans.size();
            if(need == 0) return ans;
            int n = Math.min(need, buckets[i].size());
            Collections.sort(buckets[i]);
            for(int j = 0; j < n; j++)
                ans.add((String) buckets[i].get(j));
        } 
        return ans;
    }
}