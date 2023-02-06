

class Solution {
    public boolean isBipartite(int[][] graph) {
        //build graph g
        //adjacency table
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < graph.length; i++){
            if(g.get(i) == null)
                g.put(i, new ArrayList<>());
            for(int nbr : graph[i]){
                if(g.get(nbr) == null)
                    g.put(nbr, new ArrayList<>());
                g.get(nbr).add(i);
                g.get(i).add(nbr);
            }        
        }
        
        int [] colors = new int [graph.length];
        for(int i = 0; i < graph.length; i++)
            if(colors[i] == 0 && !dfs(colors, g, i, 1)) 
                return false;
        return true;
    }
    
    public boolean dfs(int [] colors, Map<Integer, List<Integer>> g,
                       int cur, int color){
        colors[cur] = color;
        int next_color = (color == 1 ? 2 : 1);
        for(int nbr : g.get(cur)){
            if(colors[nbr] == color) return false;
            if(colors[nbr] == next_color) continue;
            if(!dfs(colors, g, nbr, next_color)) return false;
        }
        return true;
    }
}