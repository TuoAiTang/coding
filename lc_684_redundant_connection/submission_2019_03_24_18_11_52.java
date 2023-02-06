

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int [] parents = new int [n + 1];
        int [] sizes = new int [n + 1];
        
        for(int [] e : edges){
            int u = e[0];
            int v = e[1];
            if(parents[u] == 0) parents[u] = u;
            if(parents[v] == 0) parents[v] = v;
            
            int pu = find(u, parents);
            int pv = find(v, parents);
            
            if(pu == pv) return e;
            
            if(sizes[pu] > sizes[pv]){
                parents[pv] = pu;
                sizes[pu] += sizes[pv];
            }else{
                parents[pu] = pv;
                sizes[pv] += sizes[pu];
            }
        }
        
        return null;
    }
    
    public int find(int id, int [] p){
        if(p[id] != id)
            p[id] = find(p[id], p);
        return p[id];
    }
}