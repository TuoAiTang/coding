

class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] colors = new int[graph.length]; //0 -> unknown; 1 -> red; -1 -> blue;
        for(int i = 0; i < graph.length; i++)
        	if(colors[i] == 0 && !dfs(i, 1, graph, colors))
        		return false;
         return true;
    }
    
    private boolean dfs(int cur, int color, int [][] g, int [] colors){
    	colors[cur] = color;
    	for(int next : g[cur]){
    		if(colors[next] == color) return false;
    		if(colors[next] == 0 && !dfs(next, -color, g, colors))
    			return false;
    	}
    	return true;
    }
}