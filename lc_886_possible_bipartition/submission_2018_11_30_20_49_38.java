

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
    	//sparse graph -> construct by adjacency table
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < N; i++)
        	g.add(new ArrayList<>());
        for(int [] d : dislikes){
        	g.get(d[0] - 1).add(d[1] - 1);
        	g.get(d[1] - 1).add(d[0] - 1);
        }

        int [] colors = new int[N]; //0 -> unknown; 1 -> red; -1 -> blue;

        for(int i = 0; i < N; i++){
        	if(colors[i] != 0) continue;
        	if(!dfs(i, 1, colors, g)) return false;
        }
        return true;
    }

    private boolean dfs(int cur, int color, int [] colors, List<List<Integer>> g){
    	colors[cur] = color;
    	for(int next : g.get(cur)){
    		if(colors[next] == color) return false;
    		if(colors[next] == 0 && !dfs(next, -color, colors, g))
    			return false;
    	}
    	return true;
    }
}