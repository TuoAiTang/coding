

class Solution {
    public boolean isBipartite(int[][] graph) {  
        int [] colors = new int [graph.length];
        for(int i = 0; i < graph.length; i++)
            if(colors[i] == 0 && !dfs(colors, graph, i, 1)) 
                return false;
        return true;
    }
    
    public boolean dfs(int [] colors, int [][] g,
                       int cur, int color){
        colors[cur] = color;
        int next_color = (color == 1 ? 2 : 1);
        for(int nbr : g[cur]){
            if(colors[nbr] == color) return false;
            if(colors[nbr] == next_color) continue;
            if(!dfs(colors, g, nbr, next_color)) return false;
        }
        return true;
    }
}