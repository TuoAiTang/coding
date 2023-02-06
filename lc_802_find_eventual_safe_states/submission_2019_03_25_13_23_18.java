

class Solution {
    //4 state
    int UNKNOWN = 0;
    int VISITING = 1;
    int UNSAFE = 2;
    int SAFE = 3;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int [] state = new int [graph.length];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            if(dfs(graph, i, state) == SAFE)
                ans.add(i);
        }
        return ans;
    }
    
    public int dfs(int [][] g, int cur, int [] state){
        if(state[cur] == VISITING)
            return state[cur] = UNSAFE;
        if(state[cur] != UNKNOWN)
            return state[cur];
        state[cur] = VISITING;
        for(int nbr : g[cur]){
            if(dfs(g, nbr, state) == UNSAFE)
                return state[cur] = UNSAFE;
        }
        return state[cur] = SAFE;
    }
}