

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
		//construct adjacency graph
        Map<Integer, List<int []>> g = new HashMap<>();
        for(int[] edge : times){
        	if(!g.containsKey(edge[0] - 1))
        		g.put(edge[0] - 1, new ArrayList<>());
        	g.get(edge[0] - 1).add(new int [] {edge[1] - 1, edge[2]});
        }

        boolean [] collected = new boolean[N];
        collected[K - 1] = true;
        int ans = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        if(g.containsKey(K - 1)) pq.addAll(g.get(K - 1));

        while(!pq.isEmpty()){
        	int [] cur = pq.remove();
        	if(collected[cur[0]]) continue;
        	collected[cur[0]] = true;
        	List<int []> neighbors = g.get(cur[0]);
        	if(neighbors != null)
        		for(int [] neighbor : neighbors)
        			if(!collected[neighbor[0]])
        				pq.add(new int[] {neighbor[0], cur[1] + neighbor[1]});
			ans = Math.max(ans, cur[1]);
        }

        for(int i = 0; i < N; i++)
        	if(!collected[i])
        		return -1;
    	return ans;
	}
}