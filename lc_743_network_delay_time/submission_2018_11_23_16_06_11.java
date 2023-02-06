

class Solution {
    class Node{
		int vertex;
		int dist;
		public Node(int vertex_, int dist_){vertex = vertex_; dist = dist_;}
	}
    public int networkDelayTime(int[][] times, int N, int K) {
    	//construct adjacency graph
        Map<Integer, List<Node>> g = new HashMap<>();
        for(int[] edge : times){
        	if(!g.containsKey(edge[0] - 1))
        		g.put(edge[0] - 1, new ArrayList<>());
        	g.get(edge[0] - 1).add(new Node(edge[1] - 1, edge[2]));
        }


        int MAX_TIME = 101 * 100;

        //init dist
        int [] dist = new int[N];
        for(int i = 0; i < N; i++)
        	dist[i] = MAX_TIME;
        dist[K - 1] = 0;

        //ini collected, false default
        boolean [] collected = new boolean[N];

        while(true){
        	int u = getMinVertex(dist, collected);
        	if(u == -1 || dist[u] == MAX_TIME) break;
        	collected[u] = true;
        	if(!g.containsKey(u)) continue;
        	for(Node n : g.get(u)){
        		if(!collected[n.vertex])
        			dist[n.vertex] = Math.min(dist[n.vertex], dist[u] + n.dist);
        	}
        }

        int delay = getMax(dist);
        return delay == MAX_TIME ? -1 : delay;       
    }

    private int getMinVertex(int [] dist, boolean [] collected){
    	int minv = 0;
        while(minv < dist.length && collected[minv]) minv++;
        if(minv == dist.length) return -1;
    	for(int i = minv + 1; i < dist.length; i++){
    		if(collected[i]) continue;
    		if(dist[i] < dist[minv]) minv = i;
    	}
    	return minv;
    }

    private int getMax(int [] arr){
		int max_val = arr[0];
		for(int i = 1; i < arr.length; i++)
			max_val = Math.max(max_val, arr[i]);
		return max_val;
	}
}