

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        //build graph
        int [][] g = new int [N + 1][N + 1];
        for(int [] a : g)
            Arrays.fill(a, -1);
        for(int i = 0; i < N; i++)
            g[i][i] = 0;
        for(int [] e : times){
            int u = e[0], v = e[1], w = e[2];
            g[u][v] = w;
        }
        
        int MAX_VAL = N * 100;
        int [] dist = new int [N + 1];
        Arrays.fill(dist, MAX_VAL);
        dist[K] = 0;
        
        int [] collected = new int [N + 1];
        int ans = -1;
        int u;
        while((u = getMinVertex(dist, collected))!= -1 && dist[u] != MAX_VAL){  
            collected[u] = 1;
            ans = Math.max(ans, dist[u]);
            for(int i = 1; i <= N; i++)
                if(g[u][i] != -1)
                    dist[i] = Math.min(dist[i], dist[u] + g[u][i]);
        }
        return u == -1 ? ans : -1;
    }
    
    public int getMinVertex(int [] dist, int [] collected){
        int index = -1;
        int min_val = Integer.MAX_VALUE;
        for(int i = 1; i < dist.length; i++){
            if(collected[i] == 0 && dist[i] < min_val){
                min_val = dist[i];
                index = i;
            }
        }
        return index;
    }
}