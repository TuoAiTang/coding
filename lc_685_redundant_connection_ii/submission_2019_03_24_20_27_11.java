

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int [] parents = new int[edges.length + 1];
        int [] roots = new int[edges.length + 1];
        int [] sizes = new int[edges.length + 1];

        int [] ans1 = new int[2];
        int [] ans2 = new int[2];

        //first pass: find the two edge causes a node has two parents
        for(int i = 0; i < edges.length; i ++){
        	int u = edges[i][0];
        	int v = edges[i][1];
            
            if(parents[v] > 0){
                //origin edge
                ans1[0] = parents[v];
                ans1[1] = v;
                
                //later edge
                ans2[0] = u;
                ans2[1] = v;
                
                //delete later edge
                //if cycle remains
                //return ans1
                edges[i][0] = edges[i][1] = -1;
            }
        	
            parents[v] = u;
        }

        //regard as un-directed graph (684)
     	for(int i = 0; i < edges.length; i ++){
     		int u = edges[i][0];
     		int v = edges[i][1];
            
            if(u == -1 && v == -1) continue;
            
            if(roots[u] == 0) roots[u] = u;
            if(roots[v] == 0) roots[v] = v;
            
            int pu = find(u, roots);
            int pv = find(v, roots);
            
            if(pu == pv) 
                return ans1[0] == 0 ? edges[i] : ans1;
            
            if(sizes[pu] > sizes[pv]){
                int tmp = pv; pv = pu; pu = tmp;
            }
            
            roots[pu] = pv;
            sizes[pv] += sizes[pu];
     	}

     	return ans2[0] == 0 ? null : ans2;
    }

    private int find(int id, int [] parents){
    	if(parents[id] != id)
            parents[id] = find(parents[id], parents);
        return parents[id];
    }
}