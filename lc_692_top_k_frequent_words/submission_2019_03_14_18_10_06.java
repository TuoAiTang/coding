

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> ans = new LinkedList<>();
        Map<String, Integer> counts = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(
        				(a, b) -> (counts.get(a) == counts.get(b) ? b.compareTo(a) : (counts.get(a) - counts.get(b)) )
        );


        for(String word : words)
        	counts.put(word, counts.getOrDefault(word, 0) + 1);

        for(String word : counts.keySet()){
        	pq.offer(word);
        	if(pq.size() > k)
        		pq.poll();
        }

        while(k-- > 0)
        	ans.addFirst(pq.poll());

        return ans;
    }
}