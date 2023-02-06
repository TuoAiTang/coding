

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        int max_freq = 1;
        
        LinkedList<String> ans = new LinkedList<>();
        for(String word : words){
            counts.put(word, counts.getOrDefault(word, 0) + 1);
            max_freq = Math.max(max_freq, counts.get(word));
        }
        
        List<List<String>> buckets = new ArrayList<>();
        
        for(int i = max_freq + 1; i > 0; i--)
        	buckets.add(new ArrayList<>());
        
        for(String word : counts.keySet())
            buckets.get(counts.get(word)).add(word);
        
        for(int i = max_freq; i > 0; i --){
            int need = k - ans.size();
            int bsize = buckets.get(i).size();
            if(need == 0) return ans;
            if(bsize == 0) continue;
            int n = Math.min(need, bsize);
            Collections.sort(buckets.get(i));
            for(int j = 0; j < n; j++)
                ans.add(buckets.get(i).get(j));
        } 
        return ans;
    }
}