

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
		int [] parents = new int[n + 1];
        int [] sizes = new int[n + 1];

        for(int i = 0; i < n; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(parents[u] == 0) parents[u] = u;
            if(parents[v] == 0) parents[v] = v;

            int pu = find(u, parents);
            int pv = find(v, parents);

            //already in one path, return this redundant edge
            if(pu == pv) return edges[i];

            //always merge smaller set to larger set
            if(sizes[pu] > sizes[pv]){
                parents[pv] = pu;
                sizes[pu] += sizes[pv];
            }

            else{
                parents[pu] = pv;
                sizes[pv] += sizes[pu];
            }
        }

        return null;
    }

    private int find(int id, int [] parents){
        //simple path compression, not very ideal
        while(parents[id] != id){
            parents[id] = parents[parents[id]];
            id = parents[id];
        }       
        return parents[id];
    }
}