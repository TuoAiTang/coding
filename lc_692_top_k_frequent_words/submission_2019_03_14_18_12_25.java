

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> ans = new LinkedList<>();
        Map<String, Integer> counts = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(
        				(a, b) -> (counts.get(a) == counts.get(b) ? a.compareTo(b) : (counts.get(b) - counts.get(a)) )
        );


        for(String word : words)
        	counts.put(word, counts.getOrDefault(word, 0) + 1);

        for(String word : counts.keySet())
        	pq.offer(word);


        while(k-- > 0)
        	ans.add(pq.poll());

        return ans;
    }
}